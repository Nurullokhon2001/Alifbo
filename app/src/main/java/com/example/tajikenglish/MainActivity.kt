package com.example.tajikenglish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.appcompat.widget.Toolbar
import com.example.tajikenglish.Settings.SettingsFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.container,MainFragment()).commit()
        val toolbar  : Toolbar = findViewById(R.id.toolbar)
        // создали переменную toolbar и  зашли в xml и достали нужный id присваили к переменную нужный нам id
        setSupportActionBar(toolbar)
        // установили tollbar
        toolbar.setNavigationOnClickListener {
            val fragment = supportFragmentManager.beginTransaction()
            fragment.replace(R.id.container, SettingsFragment()).addToBackStack(SettingsFragment()::class.java.simpleName).commit()
            // поместили фрагмент SettingsFragment() в переменную fragment
        }




    }


}