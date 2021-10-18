package com.example.tajikenglish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tajikenglish.MainMenu.View.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.container, MainFragment()).commit()
    }


}