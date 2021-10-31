package com.example.tajikenglish

import android.Manifest
import android.annotation.SuppressLint
import android.app.Dialog
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.media.MediaScannerConnection
import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.lifecycle.ViewModelProvider
import com.example.tajikenglish.modules.models.DrawModel
import com.example.tajikenglish.modules.models.DrawImageModel
import com.encom.dynamicview.vm.DrawViewModel
import com.example.tajikenglish.modules.models.AlphabetsModel
import kotlinx.android.synthetic.main.activity_draw.*
import kotlinx.android.synthetic.main.dialog_brush_size.*
import kotlinx.android.synthetic.main.fragment_alphabet_draw.*

import java.io.InputStream


class AlphabetDrawFragment : Fragment(), View.OnClickListener {
    private lateinit var linearLayout: LinearLayout
    private lateinit var viewModel: DrawViewModel
    private var mImageButtonCurrentPaint: ImageButton? =
        null// Переменная для текущего цвета выбирается из палитры цветов.

    var alphabetArray: DrawModel =
        (DrawModel(0, "А а", "draw/1.jpg"))

    lateinit var ll_paint_colors: LinearLayout
    lateinit var ib_brush: ImageButton
    lateinit var ib_undo: ImageButton
    lateinit var ib_save: ImageButton
    lateinit var fl_drawing_view_container: FrameLayout
    lateinit var orange: ImageButton
    lateinit var black: ImageButton
    lateinit var red: ImageButton
    lateinit var green: ImageButton
    lateinit var blue: ImageButton
    lateinit var yellow: ImageButton
    lateinit var greenhigh: ImageButton
    lateinit var fiolet: ImageButton


    lateinit var imagedraw: ImageView
    private lateinit var drawing_view: com.example.tajikenglish.modules.draw_alphabet.vm.DrawingView


    var itemAlphabet: Int = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(this).get(DrawViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_alphabet_draw, container, false)
        linearLayout = view.findViewById<LinearLayout>(R.id.linearLayout)

        drawing_view = view.findViewById(R.id.drawing_view)
        ll_paint_colors = view.findViewById(R.id.ll_paint_colors)
        ib_brush = view.findViewById(R.id.ib_brush)
        ib_undo = view.findViewById(R.id.ib_undo)
        ib_save = view.findViewById(R.id.ib_save)
        fl_drawing_view_container = view.findViewById(R.id.fl_drawing_view_container)
        imagedraw = view.findViewById(R.id.imagedraw)
        orange = view.findViewById(R.id.orange)
        black = view.findViewById(R.id.black)
        red = view.findViewById(R.id.red)
        green = view.findViewById(R.id.green)
        yellow = view.findViewById(R.id.yellow)
        greenhigh = view.findViewById(R.id.greenhigh)
        fiolet = view.findViewById(R.id.fiolet)
        blue = view.findViewById(R.id.blue)




        orange.setOnClickListener(this)
        black.setOnClickListener(this)
        red.setOnClickListener(this)
        green.setOnClickListener(this)
        blue.setOnClickListener(this)
        yellow.setOnClickListener(this)
        greenhigh.setOnClickListener(this)
        fiolet.setOnClickListener(this)



        drawing_view.setSizeForBrush(20.toFloat()) // Setting the default brush size to drawing v

        mImageButtonCurrentPaint = ll_paint_colors[1] as ImageButton

        mImageButtonCurrentPaint!!.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
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


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initializeViews(alphabetArray)
    }

    override fun onClick(v: View?) {
        v?.let {
            when (v.id) {
                R.id.orange -> {
                    paintClicked(ll_paint_colors[0])
                }
                R.id.black -> {
                    paintClicked(ll_paint_colors[1])
                }
                R.id.red -> {
                    paintClicked(ll_paint_colors[2])
                }
                R.id.green -> {
                    paintClicked(ll_paint_colors[3])
                }
                R.id.blue -> {
                    paintClicked(ll_paint_colors[4])
                }
                R.id.yellow -> {
                    paintClicked(ll_paint_colors[5])
                }
                R.id.greenhigh -> {
                    paintClicked(ll_paint_colors[6])
                }
                R.id.fiolet -> {
                    paintClicked(ll_paint_colors[7])
                }

            }
        }
    }

//    fun initializeViews(alphabets: DrawImageModel) {
//
//        val itemView: View = layoutInflater.inflate(R.layout.item_second_view, linearLayout, false)
//
//
//        val inputStream: InputStream = requireContext().getAssets().open(alphabets.ImageVIew)
//        val image = Drawable.createFromStream(inputStream, null)
//
//
//        itemView.findViewById<ImageView>(R.id.ImageView).setImageDrawable(image)
//
//        imagedraw.setImageDrawable(image)
//
////        itemView.setOnClickListener(this)
////        itemView.setTag(alphabets)
////        linearLayout.addView(itemView)
//
//    }


    private fun initializeViews(alphabets: DrawModel) {


        val itemView: View = layoutInflater.inflate(R.layout.item_second_view, linearLayout, false)


        val inputStream: InputStream = requireContext().getAssets().open(alphabets.imageModel)
        val image = Drawable.createFromStream(inputStream, null)


        itemView.findViewById<ImageView>(R.id.ImageView).setImageDrawable(image)

        imagedraw.setImageDrawable(image)

//        itemView.setOnClickListener(this)
//        itemView.setTag(alphabets)
//        linearLayout.addView(itemView)

        }



    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        //Проверка кода запроса нашего запроса
        if (requestCode == STORAGE_PERMISSION_CODE) {

            //Если разрешение будет предоставлено
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(
                    requireContext(),
                    "Разрешение предоставлено, теперь вы можете читать файлы хранилища.",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                //Displaying another toast if permission is not granted
                Toast.makeText(
                    requireContext(),
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
        val brushDialog = Dialog(requireContext())
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
            imageButton.setImageDrawable(ContextCompat.getDrawable(requireContext(),
                R.drawable.pallet_pressed))
            mImageButtonCurrentPaint!!.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
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
                requireActivity(),
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
            requireActivity(), arrayOf(
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
            requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE
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

            return result
        }

        override fun onPostExecute(result: String) {
            super.onPostExecute(result)

            cancelProgressDialog()

            if (!result.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Файл успешно сохранен:$result",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    requireContext(),
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
                requireContext(), arrayOf(result), null
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
                requireContext(),
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

//        override fun doInBackground(vararg p0: Any?): String {
//            TODO("Not yet implemented")
//        }
    }


    companion object {
        fun newInstance(itemContact: DrawModel): AlphabetDrawFragment {

            val fragment = AlphabetDrawFragment()
            fragment.alphabetArray = itemContact
            return fragment
        }

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
