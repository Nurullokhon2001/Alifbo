package com.example.tajikenglish.modules.draw_alphabet.vm

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View

/**
 * Этот класс содержит атрибуты для основного макета
 * нашего приложения.
 */

/**
 * Конструктор для отрисовки вида
 * Этот конструктор вызывает функцию setupDrawing()
 * метод. Этот конструктор вызывается только
 * один раз, когда макет приложения является первым
 * создается при запуске.
 *
 * @param context
 * @param attrs
 */

/**
 * Ссылка для создания этого класса является
 * https://medium.com/@ssaurel/learn-to-create-a-paint-application-for-android-5b16968063f8
 */
@SuppressLint("NewApi")
class DrawingView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private var mDrawPath: CustomPath? =
        null// Переменная внутреннего класса CustomPath для ее дальнейшего использования.
    private var mCanvasBitmap: Bitmap? = null // Экземпляр растрового изображения.

    private var mDrawPaint: Paint? =
        null // Класс Paint содержит информацию о стиле и цвете для рисования геометрических фигур, текста и растровых изображений.
    private var mCanvasPaint: Paint? = null // Экземпляр представления краски на холсте.

    private var mBrushSize: Float =
        0.toFloat() // Переменная для размера штриха/кисти для рисования на холсте.

    // Переменная для хранения цвета штриха.
    private var color = Color.BLACK

    /**
     * Переменная для canvas, которая будет инициализирована позже и использована.
     *
     *Класс Canvas содержит вызовы "рисовать". Чтобы что-то нарисовать, вам нужны 4 основных компонента: Растровое изображение для размещения пикселей, холст для размещения
     * вызовы рисования (запись в растровое изображение), примитив рисования (например, прямая,
     * Путь, текст, растровое изображение) и краска (для описания цветов и стилей для
     * рисунка)
     */
    private var canvas: Canvas? = null

    private val mPaths = ArrayList<CustomPath>() // Список массивов для путей

    private val mUndoPaths = ArrayList<CustomPath>()

    init {
        setUpDrawing()
    }

    /**
     * Этот метод инициализирует атрибуты
    класса * ViewForDrawing.
     */
    private fun setUpDrawing() {
        mDrawPaint = Paint()
        mDrawPath = CustomPath(color, mBrushSize)

        mDrawPaint!!.color = color

        mDrawPaint!!.style = Paint.Style.STROKE // Это для того, чтобы нарисовать стиль ШТРИХА
        mDrawPaint!!.strokeJoin = Paint.Join.ROUND // Это для присоединения к магазину
        mDrawPaint!!.strokeCap = Paint.Cap.ROUND // Это для крышки хода

        mCanvasPaint = Paint(Paint.DITHER_FLAG) // Флаг рисования, который позволяет сглаживать при размытии.

        mBrushSize =
            20.toFloat() // Здесь определяется размер кисти/ мазка по умолчанию или мы можем задать начальный размер кисти / мазка.
    }

    override fun onSizeChanged(w: Int, h: Int, wprev: Int, hprev: Int) {
        super.onSizeChanged(w, h, wprev, hprev)
        mCanvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        canvas = Canvas(mCanvasBitmap!!)
    }

    /**
     * Этот метод вызывается, когда на холсте рисуется штрих
     * как часть картины.
     */
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)




        /**
         * Нарисуйте указанное растровое изображение с его верхним/левым углом в (x,y), используя указанную краску,
         * преобразованную текущей матрицей.
         *
         *Если растровое изображение и холст имеют разную плотность, эта функция позаботится о
         * автоматическом масштабировании растрового изображения для рисования с той же плотностью, что и холст.
         *
         * @param bitmap изображение Растровое изображение, которое будет нарисовано
         * @param left положение левой стороны рисуемого растрового изображения
         * @param top Положение верхней стороны рисуемого растрового изображения
         * @param paint краску, используемую для рисования растрового изображения (может быть равно нулю)
         */



        canvas.drawBitmap(mCanvasBitmap!!, 0f, 0f, mCanvasPaint)

        for (p in mPaths) {
            mDrawPaint!!.strokeWidth = p.brushThickness
            mDrawPaint!!.color = p.color
            canvas.drawPath(p, mDrawPaint!!)
        }

        if (!mDrawPath!!.isEmpty) {
            mDrawPaint!!.strokeWidth = mDrawPath!!.brushThickness
            mDrawPaint!!.color = mDrawPath!!.color
            canvas.drawPath(mDrawPath!!, mDrawPaint!!)
        }
    }

    /**
     * Этот метод действует как прослушиватель событий, когда прикосновение
     * на устройстве обнаружено событие.
     */
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val touchX = event.x // Touch event of X coordinate
        val touchY = event.y // touch event of Y coordinate

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                mDrawPath!!.color = color
                mDrawPath!!.brushThickness = mBrushSize

                mDrawPath!!.reset() // Удалите все линии и кривые с пути, сделав его пустым.
                mDrawPath!!.moveTo(
                    touchX,
                    touchY
                ) // Установите начало следующего контура в точку (x,y).
            }

            MotionEvent.ACTION_MOVE -> {
                mDrawPath!!.lineTo(
                    touchX,
                    touchY
                ) // Добавьте линию от последней точки до указанной точки (x,y).
            }

            MotionEvent.ACTION_UP -> {

                mPaths.add(mDrawPath!!) //Добавить, когда обводка рисуется на холсте и добавляется в список путей

                mDrawPath = CustomPath(color, mBrushSize)
            }
            else -> return false
        }

        invalidate()
        return true
    }

    /**
     * Этот метод вызывается, когда либо кисть, либо ластик
     * размеры должны быть изменены. Этот метод устанавливает кисть/ластик
     * размеры до новых значений в зависимости от выбора пользователя.
     */
    fun setSizeForBrush(newSize: Float) {
        mBrushSize = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, newSize,
                resources.displayMetrics
        )
        mDrawPaint!!.strokeWidth = mBrushSize
    }

    /**
     * Эта функция вызывается, когда пользователь желает изменить цвет.
     * Эта функция устанавливает цвет магазина в выбранный цвет и позволяет рисовать на экране, используя этот цвет.
     *
     * @param newColor
     */
    fun setColor(newColor: String) {
        color = Color.parseColor(newColor)
        mDrawPaint!!.color = color
    }

    /**
     * Эта функция вызывается, когда пользователь выбирает отмену
     * команда из приложения. Эта функция удаляет
     * последний штрих, введенный пользователем, в зависимости от
     * количества раз, когда была активирована отмена.
     */
    fun onClickUndo() {
        if (mPaths.size > 0) {

            mUndoPaths.add(mPaths.removeAt(mPaths.size - 1))
            invalidate() // Invalidate the whole view. If the view is visible
        }
    }

    // // Внутренний класс для пользовательского пути с двумя параметрами, такими как цвет и размер штриха.
    internal inner class CustomPath(var color: Int, var brushThickness: Float) : Path()
}