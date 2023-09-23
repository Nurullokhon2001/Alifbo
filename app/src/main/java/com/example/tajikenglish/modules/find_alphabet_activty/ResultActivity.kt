package com.example.tajikenglish.modules.find_alphabet_activty

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tajikenglish.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        // TODO (STEP 6: Hide the status bar and g
        //
        //  et the details from intent and set it to the UI. And also add a click event to the finish button.)
        // START
        // Hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN


        val totalQuestions = intent.getIntExtra(TestConstants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(TestConstants.CORRECT_ANSWERS, 0)

        findViewById<TextView>(R.id.tv_score).text =
            "Ҷавоби дурустии шумо аз $totalQuestions -  $correctAnswers то."



        findViewById<Button>(R.id.btn_finish).setOnClickListener {
            super.onBackPressed()
        }
        // END
    }
}