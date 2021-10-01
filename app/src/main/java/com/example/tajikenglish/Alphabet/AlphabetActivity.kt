package com.example.tajikenglish.Alphabet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.encom.dynamicview.view.*

import com.example.tajikenglish.MainActivity
import com.example.tajikenglish.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class AlphabetActivity : AppCompatActivity() {
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

        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, AlphabetMainCviewFragment())
            .commit()
        supportFragmentManager.beginTransaction().replace(R.id.fragment, AlphabetCviewFragment())
            .commit()

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.abclearn -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, AlphabetMainCviewFragment())
                        .commit()
                    supportFragmentManager.beginTransaction().replace(R.id.fragment, AlphabetCviewFragment())
                        .commit()
                }
                R.id.abcdraw->{
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, HamsadoMainCviewFragment())
                        .commit()
                    supportFragmentManager.beginTransaction().replace(R.id.fragment, HamsadoCviewFragment())
                        .commit()
                }
                R.id.abcgame->{
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,SadonokMainCviewFragment())
                        .commit()
                    supportFragmentManager.beginTransaction().replace(R.id.fragment, SadonokCviewFragment())
                        .commit()
                }
            }
            true
        }

    }
}