package com.example.tajikenglish.modules.find_alphabet_activty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.tajikenglish.R

class TestAlphabetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_alphabet)
        // To hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        findViewById<Button>(R.id.btn_start).setOnClickListener {



            val intent = Intent(this, TestQuestionsActivity::class.java)

            startActivity(intent)
            finish()

        }
    }
}