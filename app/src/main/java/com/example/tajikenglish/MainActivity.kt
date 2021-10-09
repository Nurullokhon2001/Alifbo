package com.example.tajikenglish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.appcompat.widget.Toolbar
import com.example.tajikenglish.Settings.SettingsFragment


class MainActivity : AppCompatActivity() {
  private  lateinit var toolbar: Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment()).commit()


         toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        toolbar.setNavigationOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SettingsFragment())
                .addToBackStack(SettingsFragment()::class.java.simpleName).commit()
        }
    }
}