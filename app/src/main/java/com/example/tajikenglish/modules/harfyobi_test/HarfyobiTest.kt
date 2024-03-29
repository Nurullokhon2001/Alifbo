package com.example.tajikenglish.modules.harfyobi_test

import android.content.Intent
import android.content.res.AssetFileDescriptor
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.tajikenglish.R
import com.example.tajikenglish.modules.find_alphabet_activty.TestConstants
import com.example.tajikenglish.modules.find_alphabet_activty.ResultActivity
import com.example.tajikenglish.modules.models.HarfyobiModel
import java.io.InputStream

class HarfyobiTest : AppCompatActivity(),View.OnClickListener {
    private var mCurrentPosition: Int = 1 // Default and the first question position
    private var mQuestionsList: ArrayList<HarfyobiModel> = ArrayList()
    var mp: MediaPlayer? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0

    var tv_speech : String =" "

    // TODO (STEP 3: Create a variable for getting the name from intent.)
    // START
    private var mUserName: String? = null
    // END

    private lateinit var tv_option_one: TextView
    private lateinit var tv_option_two: TextView
    private lateinit var tv_option_three: TextView
    private lateinit var tv_option_four: TextView
    private lateinit var tv_progress: TextView
    private lateinit var tv_question: TextView
    private lateinit var iv_image: ImageView
    private lateinit var btn_submit: Button
    private lateinit var progressBar: ProgressBar

    private var toast: String? = null
    /**
     * This function is auto created by Android when the Activity Class is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_harfyobi_test)

        // TODO (STEP 4: Get the NAME from intent and assign it the variable.)
        // START
        // mUserName = intent.getStringExtra(Constants.USER_NAME)
        // END

        var back : ImageView = findViewById(R.id.back)

        back.setOnClickListener {
            super.onBackPressed()
        }

        mQuestionsList = harfyobi.getQuestions()

        setQuestion()
        tv_option_one = findViewById(R.id.tv_option_one)
        tv_option_two = findViewById(R.id.tv_option_two)
        tv_option_three = findViewById(R.id.tv_option_three)
        tv_option_four = findViewById(R.id.tv_option_four)
        tv_progress = findViewById(R.id.tv_progress)
        tv_question = findViewById(R.id.tv_question)
        iv_image = findViewById(R.id.iv_image)
        btn_submit = findViewById(R.id.btn_submit)
        progressBar = findViewById(R.id.progressBar)

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        iv_image.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v?.id) {

            R.id.tv_option_one -> {

                selectedOptionView(tv_option_one, 1)
            }

            R.id.tv_option_two -> {

                selectedOptionView(tv_option_two, 2)
            }

            R.id.tv_option_three -> {

                selectedOptionView(tv_option_three, 3)
            }

            R.id.tv_option_four -> {

                selectedOptionView(tv_option_four, 4)
            }
            R.id.iv_image -> {
                setQuestion2()

       //         Toast.makeText(this, "${tv_speech}", Toast.LENGTH_SHORT).show()
              //  audioPlayer(tv_speech)
            }

            R.id.btn_submit -> {

                if (mSelectedOptionPosition == 0) {

                    mCurrentPosition++

                    when {

                        mCurrentPosition <= mQuestionsList!!.size -> {

                            setQuestion()
                        }
                        else -> {

                            // TODO (STEP 5: Now remove the toast message and launch the result screen which we have created and also pass the user name and score details to it.)
                            // START
                            val intent =
                                Intent(this@HarfyobiTest, ResultActivity::class.java)
                            intent.putExtra(TestConstants.USER_NAME, mUserName)
                            intent.putExtra(TestConstants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(TestConstants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)
                            finish()
                            // END
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)

                    // This is to check if the answer is wrong
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }
                    else {
                        mCorrectAnswers++
                    }

                    // This is for correct answer
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionsList!!.size) {
                        btn_submit.text = "Итмом"
                    } else {
                        btn_submit.text = "Саволи дигар"
                    }

                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    /**
     * A function for setting the question to UI components.
     */
    private fun setQuestion() {

        val question = mQuestionsList!!.get(mCurrentPosition - 1) // Getting the question from the list with the help of current position.

        defaultOptionsView()

        if (mCurrentPosition == mQuestionsList!!.size) {
            btn_submit.text = "Итмом"
        } else {
            btn_submit.text = "Ба пеш"
        }

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.getMax()

        val inputStream: InputStream =
            this.getAssets().open(question.icon)
        val image = Drawable.createFromStream(inputStream, null)
        iv_image.setImageDrawable(image)

        tv_question.text = question.question


        //iv_image.setImageResource(R.drawable.speech)


        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
        tv_speech  = question.speech
    }

    /**
     * A function to set the view of selected option view.
     */
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(
            Color.parseColor("#363A43")
        )
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this@HarfyobiTest,
            R.drawable.selected_option_border_bg
        )
    }

    /**
     * A function to set default options view when the new question is loaded or when the answer is reselected.
     */
    private fun defaultOptionsView() {

        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this@HarfyobiTest,
                R.drawable.default_option_border_bg
            )
        }
    }

    /**
     * A function for answer view which is used to highlight the answer is wrong or right.
     */
    private fun answerView(answer: Int, drawableView: Int) {

        when (answer) {

            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(
                    this@HarfyobiTest,
                    drawableView
                )
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(
                    this@HarfyobiTest,
                    drawableView
                )
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(
                    this@HarfyobiTest,
                    drawableView
                )
            }
            4 -> {
                tv_option_four.background = ContextCompat.getDrawable(
                    this@HarfyobiTest,
                    drawableView
                )
            }
        }
    }




    private fun setQuestion2() {

        val question = mQuestionsList!!.get(mCurrentPosition - 1) // Getting the question from the list with the help of current position.

        defaultOptionsView()




        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.getMax()

        toast = question.question

    }

    fun audioPlayer(fullPath: String) {
        try {
            if (mp != null) {
                mp?.stop()
                mp?.release()
                mp = null
            }
            mp = MediaPlayer()
            val decs: AssetFileDescriptor = this.resources.assets.openFd(fullPath)
            mp?.setDataSource(decs.fileDescriptor, decs.startOffset, decs.length)
            decs.close()
            mp?.prepare()
            mp?.setVolume(1f, 1f)
            mp?.isLooping = false

            mp?.start()
        } catch (ex: Exception) {
            Log.i("", ex.message!!)
        }
    }


}