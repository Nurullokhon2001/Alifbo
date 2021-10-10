package com.example.tajikenglish.Number

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

import com.example.tajikenglish.MainActivity
import com.example.tajikenglish.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class NumberActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alphabet)

        val toolbar  : Toolbar = findViewById(R.id.toolbar)
        // создали переменную toolbar и  зашли в xml и достали нужный id присваили к переменную нужный нам id
        setSupportActionBar(toolbar)
        // установили tollbar
        toolbar.setNavigationOnClickListener {
           val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            // поместили фрагмент SettingsFragment() в переменную fragment
        }

    

        bottomNavigationView = findViewById(R.id.bottom_navigation)
//

    }
}