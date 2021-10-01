package com.example.tajikenglish
import android.Manifest
import android.annotation.SuppressLint
import android.app.Dialog
import android.app.ProgressDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.media.MediaScannerConnection
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.get

import kotlinx.android.synthetic.main.activity_draw.*
import kotlinx.android.synthetic.main.dialog_brush_size.*

import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream

class DrawActivity : AppCompatActivity() {

    private var mImageButtonCurrentPaint: ImageButton? =
            null// Переменная для текущего цвета выбирается из палитры цветов.


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draw)
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, AlphabetButtonDrawFragment())
            .commit()
        supportFragmentManager.beginTransaction().replace(R.id.fragment, AlphabetDrawFragment())
            .commit()

         drawing_view.setSizeForBrush(20.toFloat()) // Setting the default brush size to drawing v

        /**
         * Это делается для выбора кнопки Изображения по умолчанию, которая
         * активна, а цвет уже определен в классе чертежного вида.
         * Поскольку цвет по умолчанию черный, поэтому в нашей цветовой палитре он находится на 2 позиции.
         * Но начальная позиция списка массивов равна 0, поэтому черный цвет находится в позиции 1.
         */
        mImageButtonCurrentPaint = ll_paint_colors[1] as ImageButton
        mImageButtonCurrentPaint!!.setImageDrawable(
                ContextCompat.getDrawable(
                        this,
                        R.drawable.pallet_pressed
                )
        )

        ib_brush.setOnClickListener {
            showBrushSizeChooserDialog()
        }



        ib_undo.setOnClickListener {
            // Это для отмены недавнего удара.
            drawing_view.onClickUndo()
        }

        ib_save.setOnClickListener {

            //Сначала проверьте, есть ли у приложения уже разрешение
            if (isReadStorageAllowed()) {

                BitmapAsyncTask(getBitmapFromView(fl_drawing_view_container)).execute()
            } else {

                //Если у приложения нет разрешения на доступ к хранилищу, мы запросим его.
                requestStoragePermission()
            }
        }
    }

    /**
     * Это метод переопределения, и метод будет вызван, когда пользователь нажмет "разрешить" или "запретить".
     *
     * Определяет, должен ли делегат обрабатывать
     * {@link ActivityCompat#Запросы(Действие, строка[], int)} и запрос
     * разрешения, если это применимо. Если этот метод возвращает значение true, это означает, что разрешение
     * запрос успешно обработан делегатом, и платформа не должна выполнять никаких
     * дальнейших запросов на получение разрешения.
     *
     * @param activity Целевая деятельность.
     * @param permissions Запрошенные разрешения. Должен быть ненулевым и не пустым.
     * @param requestCode Код запроса конкретного приложения для сопоставления с результатом, сообщенным
     */
    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<String>,
            grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        //Проверка кода запроса нашего запроса
        if (requestCode == STORAGE_PERMISSION_CODE) {

            //Если разрешение будет предоставлено
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(
                        this@DrawActivity,
                        "Разрешение предоставлено, теперь вы можете читать файлы хранилища.",
                        Toast.LENGTH_LONG
                ).show()
            } else {
                //Displaying another toast if permission is not granted
                Toast.makeText(
                        this@DrawActivity,
                        "Упс, ты только что отказал в разрешении.",
                        Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    /**
     * Это метод переопределения, здесь мы получаем выбранное изображение
     * на основе кода, который мы передали для выбора изображения.
     */


    /**
     * Метод используется для запуска диалогового окна для выбора различных размеров кисти.
     */
    private fun showBrushSizeChooserDialog() {
        val brushDialog = Dialog(this)
        brushDialog.setContentView(R.layout.dialog_brush_size)
        brushDialog.setTitle("Размер кисти :")
        val smallBtn = brushDialog.ib_small_brush
        smallBtn.setOnClickListener(View.OnClickListener {
            drawing_view.setSizeForBrush(10.toFloat())
            brushDialog.dismiss()
        })
        val mediumBtn = brushDialog.ib_medium_brush
        mediumBtn.setOnClickListener(View.OnClickListener {
            drawing_view.setSizeForBrush(20.toFloat())
            brushDialog.dismiss()
        })

        val largeBtn = brushDialog.ib_large_brush
        largeBtn.setOnClickListener(View.OnClickListener {
            drawing_view.setSizeForBrush(30.toFloat())
            brushDialog.dismiss()
        })
        brushDialog.show()
    }

    /**
     * Метод вызывается, когда цвет выбирается из pallet_normal.
     *
     * @param view ImageButton по которому произошел щелчок.
     */
    fun paintClicked(view: View) {
        if (view !== mImageButtonCurrentPaint) {
            // Обновите цвет
            val imageButton = view as ImageButton
            // Здесь тег используется для замены текущего цвета предыдущим цветом.
            // В теге хранится выбранный вид
            val colorTag = imageButton.tag.toString()
            // Цвет задается в соответствии с выбранным тегом здесь.
            drawing_view.setColor(colorTag)
            // Поменяйте местами фон для последней активной и текущей активной кнопки изображения.
            imageButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.pallet_pressed))
            mImageButtonCurrentPaint!!.setImageDrawable(
                    ContextCompat.getDrawable(
                            this,
                            R.drawable.pallet_normal
                    )
            )

            //Текущее представление обновляется выбранным представлением в виде кнопки ImageButton.
            mImageButtonCurrentPaint = view
        }
    }

    /**
     * Запрос разрешения
     */
    private fun requestStoragePermission() {

        /**
         * Получает, следует ли показывать пользовательский интерфейс с обоснованием запроса разрешения.
         * Вы должны делать это только в том случае, если у вас нет разрешения и контекста в
         * о котором запрашивается разрешение, пользователю четко не сообщается
         * какова была бы польза от предоставления этого разрешения.
         * <p>
         * Например, если вы пишете приложение для камеры, запрашивая разрешение камеры
         * будет ожидаться пользователем, и не требуется никакого обоснования того, почему он запрашивается
         *. Если, однако, приложению требуется местоположение для пометки фотографий, то нетехнологичный
         * опытный пользователь может задаться вопросом, как местоположение связано с фотографированием. В этом случае
         * вы можете выбрать отображение пользовательского интерфейса с обоснованием запроса этого разрешения.
         * </p>
         *
         * @param activity Целевая деятельность.
         * @param permission Разрешение, которое ваше приложение хочет запросить.
         * @return Можете ли вы показать пользовательский интерфейс с обоснованием разрешений.
         *
         */
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                        this,
                        arrayOf(
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE
                        ).toString()
                )
        ) {
            //Если пользователь ранее отказал в разрешении, ваш код попадет в этот блок
            //Здесь вы можете объяснить, зачем вам нужно это разрешение
            //Объясните здесь, зачем вам нужно это разрешение
        }

        /**
         * Запрашивает разрешения, которые должны быть предоставлены этому приложению. Эти разрешения
         * должны быть запрошены в вашем манифесте, в противном случае они не будут предоставлены вашему приложению.
         */

        //И, наконец, попросите разрешения
        ActivityCompat.requestPermissions(
                this, arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        ),
                STORAGE_PERMISSION_CODE
        )
    }

    /**
     * Мы вызываем этот метод, чтобы проверить статус разрешения
     */
    private fun isReadStorageAllowed(): Boolean {
        //Getting the permission status
        // Here the checkSelfPermission is
        /**
         * Определите, было ли <em>вам</em> предоставлено определенное разрешение.
         *
         * @param permission Имя проверяемого разрешения.
         *
         */
        val result = ContextCompat.checkSelfPermission(
                this, Manifest.permission.READ_EXTERNAL_STORAGE
        )

        /**
         *
         * @return {@link android.content.pm.PackageManager#PERMISSION_GRANTED} если у вас есть
         *разрешения, или {@link android.content.pm.PackageManager#PERMISSION_DENIED} если нет.
         *
         */
        //Если разрешение предоставлено, возвращает значение true, а если разрешение не предоставлено, возвращает значение false
        return result == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Создайте растровое изображение из представления и верните его
     */
    private fun getBitmapFromView(view: View): Bitmap {

        //Определите растровое изображение того же размера, что и вид.
        // CreateBitmap : Возвращает изменяемое растровое изображение с заданными шириной и высотой
        val returnedBitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        //Привяжите к нему холст
        val canvas = Canvas(returnedBitmap)
        //Получить фон представления
        val bgDrawable = view.background
        if (bgDrawable != null) {
            //имеет возможность рисования фона, затем нарисуйте его на холсте
            bgDrawable.draw(canvas)
        } else {
            //не имеет рисоваемого фона, затем нарисуйте белый фон на холсте
            canvas.drawColor(Color.WHITE)
        }
        // нарисуйте вид на холсте
        view.draw(canvas)
        //верните растровое изображение
        return returnedBitmap
    }

    /**
     * “Вложенный класс, помеченный как внутренний, может получить доступ к членам своего внешнего класса.
     * Внутренние классы содержат ссылку на объект внешнего класса:”
     * источник: https://kotlinlang.org/docs/reference/nested-classes.html
     *
     * Это класс фона, используемый для сохранения отредактированного изображения пользователя в виде растрового изображения в локальном хранилище.
     *
     * Для фона мы использовали AsyncTask
     *
     * Asynctask : Создает новую асинхронную задачу. Этот конструктор должен быть вызван в потоке пользовательского интерфейса.
     */
    @SuppressLint("StaticFieldLeak")
    private inner class BitmapAsyncTask(val mBitmap: Bitmap?) :
            AsyncTask<Any, Void, String>() {

        /**
         * ProgressDialog-это модальный диалог, который запрещает пользователю взаимодействовать с приложением.
         *
         * Диалоговое окно прогресса в более новых версиях устарело, поэтому мы создадим настраиваемое диалоговое окно прогресса позже.
         * Это просто идея использовать диалоговое окно прогресса.
         */

        @Suppress("DEPRECATION")
        private var mDialog: ProgressDialog? = null

        override fun onPreExecute() {
            super.onPreExecute()

            showProgressDialog()
        }

        override fun doInBackground(vararg params: Any): String {

            var result = ""

            if (mBitmap != null) {

                try {
                    val bytes = ByteArrayOutputStream() // Создает новый поток вывода массива байтов.
                    // Емкость буфера изначально составляет 32 байта, хотя при необходимости его размер увеличивается.
                    mBitmap.compress(Bitmap.CompressFormat.PNG, 90, bytes)
                    /**
                     * Запишите сжатую версию растрового изображения в указанный выходной поток.
                     * Если это возвращает значение true, растровое изображение можно восстановить, передав
                     * соответствующий входной поток для BitmapFactory.decodeStream(). Примечание: не
                     * все форматы поддерживают все конфигурации растровых изображений напрямую, поэтому возможно, что
                     * возвращенное растровое изображение из BitmapFactory может иметь другую глубину
                    в битах * и/или может быть потеряно альфа-изображение на пиксель (например, JPEG поддерживает только непрозрачное
                     * пикселей).
                     *
                     * @param format  Формат сжатого изображения
                     * @param quality  Подсказка компрессору, 0-100, 0 означает сжатие для
                     * малый размер, 100% сжатие для максимального качества. Некоторые
                     * форматы, такие как PNG без потерь, будут игнорировать параметр
                     * качество
                     * @param stream  Выходной поток для записи сжатых данных.
                     * @return значение true, если успешно сжато в указанный поток.
                     */

                    val f = File(
                            externalCacheDir!!.absoluteFile.toString()
                                    + File.separator + "KidDrawingApp_" + System.currentTimeMillis() / 1000 + ".jpg"
                    )
                    // Здесь Среда : Предоставляет доступ к переменным среды.
                    // getExternalStorageDirectory : возвращает основной каталог общего/внешнего хранилища.
                    // absoluteFile : Возвращает абсолютную форму этого абстрактного пути.
                    // File.separator : Зависящий от системы символ-разделитель имени по умолчанию. Эта строка содержит один символ.
                    val fo =
                            FileOutputStream(f) // Создает поток вывода файла для записи в файл, представленный указанным объектом.
                    fo.write(bytes.toByteArray()) // Записывает байты из указанного массива байтов в этот поток вывода файла.
                    fo.close() //Закрывает это поток вывода файла и освобождает любые системные ресурсы, связанные с этим потоком. Этот поток вывода файла больше не может использоваться для записи байтов.
                    result = f.absolutePath // В результате возвращается абсолютный путь к файлу.
                } catch (e: Exception) {
                    result = ""
                    e.printStackTrace()
                }
            }
            return result
        }

        override fun onPostExecute(result: String) {
            super.onPostExecute(result)

            cancelProgressDialog()

            if (!result.isEmpty()) {
                Toast.makeText(
                        this@DrawActivity,
                        "Файл успешно сохранен:$result",
                        Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                        this@DrawActivity,
                        "Что-то пошло не так при сохранении файла.",
                        Toast.LENGTH_SHORT
                ).show()
            }

            // TODO (Step 1 - Sharing the downloaded Image file)
            // НАЧАТЬ

            /*MediaScannerConnection предоставляет приложениям возможность передавать
           недавно созданный или загруженный медиафайл в службу сканирования мультимедиа.
            Служба сканирования мультимедиа считает метаданные из файла и добавит
           файл поставщику мультимедийного контента.
            MediaScannerConnectionClient предоставляет
           службе сканирования мультимедиа интерфейс для возврата Uri для только что отсканированного файла
           клиенту класса MediaScannerConnection.*/

            /*scanFile используется для сканирования файла при установлении соединения с MediaScanner.*/            MediaScannerConnection.scanFile(
                    this@DrawActivity, arrayOf(result), null
            ) { path, uri ->
                // Это используется для совместного использования изображения после того, как оно было сохранено в хранилище.
                    val shareIntent = Intent()
                    shareIntent.action = Intent.ACTION_SEND
                    shareIntent.putExtra(
                            Intent.EXTRA_STREAM,
                            uri
                    ) // Содержимое: URI, содержащий поток данных, связанных с Намерением, используемый для предоставления отправляемых данных.
                    shareIntent.type =
                            "image/jpeg" // Тип MIME данных, обрабатываемых этим намерением.
                    startActivity(
                            Intent.createChooser(
                                    shareIntent,
                                    "Share"
                            )
                    )// Действие действия: Отображение средства выбора действия,
                // позволяет пользователю выбрать то, что он хочет, прежде чем продолжить.
                // Это может быть использовано в качестве альтернативы стандартному средству выбора действий
                // это отображается системой при попытке начать действие с несколькими возможными совпадениями,
// с этими различиями в поведении:
            }
            // КОНЕЦ
        }

        /**
         * Эта функция используется для отображения диалога выполнения с заголовком и сообщением пользователю.
         */
        private fun showProgressDialog() {
            @Suppress("DEPRECATION")
            mDialog = ProgressDialog.show(
                    this@DrawActivity,
                    "",
                    "Сохранение вашего изображения..."
            )
        }

        /**
         * Эта функция используется для закрытия диалога выполнения, если он виден пользователю.
         */
        private fun cancelProgressDialog() {
            if (mDialog != null) {
                mDialog!!.dismiss()
                mDialog = null
            }
        }
    }

    companion object {

        /**
         * Код разрешения, который будет проверен в методе onRequestPermissionsResult
         *
         * Для получения более подробной информации посетите : https://developer.android.com/training/permissions/requesting#kotlin
         */
        private const val STORAGE_PERMISSION_CODE = 1

        // Это делается для определения выбора изображения из галереи.
        private const val GALLERY = 2
    }


    }
