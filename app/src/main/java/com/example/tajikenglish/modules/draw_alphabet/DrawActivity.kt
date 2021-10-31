package com.example.tajikenglish


import android.os.Bundle
import android.widget.ImageView

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.encom.dynamicview.vm.DrawViewModel
import com.example.tajikenglish.alphabet.view.AlphabetsDetailsFragment
import com.example.tajikenglish.alphabet.view.AlphabetsFragment
import com.example.tajikenglish.alphabet.vm.AlphabetsViewModel


class DrawActivity : AppCompatActivity() {

    private lateinit var vm: DrawViewModel




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draw)


        vm = ViewModelProvider(this).get(DrawViewModel::class.java)
        vm.getAlphabets().observe(this, {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, AlphabetButtonDrawFragment.newInstance(it))
                .commit()
            supportFragmentManager.beginTransaction().replace(R.id.fragment, AlphabetDrawFragment.newInstance(it[0]))
                .commit()
        })


        var back : ImageView = findViewById(R.id.back)

        back.setOnClickListener {
            super.onBackPressed()
        }




    }
}

