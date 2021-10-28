package com.example.tajikenglish


import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity


class DrawActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draw)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, AlphabetButtonDrawFragment())
            .commit()
        supportFragmentManager.beginTransaction().replace(R.id.fragment, AlphabetDrawFragment())
            .commit()


    }
}