package com.example.tajikenglish.modules.find_alphabet_activty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tajikenglish.R
import kotlinx.android.synthetic.main.activity_find_alphabet.*

class TestAlphabetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_alphabet)
        // To hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        btn_start.setOnClickListener {



            val intent = Intent(this, TestQuestionsActivity::class.java)

            startActivity(intent)
            finish()

        }
    }
}