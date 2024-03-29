package com.example.tajikenglish.alphabet

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import com.example.tajikenglish.alphabet.view.AlphabetsDetailsFragment
import com.example.tajikenglish.alphabet.view.AlphabetsFragment
import com.example.tajikenglish.alphabet.vm.AlphabetsViewModel

import com.example.tajikenglish.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class AlphabetActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var vm: AlphabetsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alphabet)

        vm = ViewModelProvider(this).get(AlphabetsViewModel::class.java)
        vm.getAlphabet().observe(this, {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, AlphabetsFragment.newInstance(it))
                .commit()

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, AlphabetsDetailsFragment.newInstance(it[0]))
                .commit()
        })




        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener(this)

        var back : ImageView = findViewById(R.id.back)

        back.setOnClickListener {
            super.onBackPressed()
        }


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.alphabet -> {
                vm.getAlphabet().observe(this, {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, AlphabetsFragment.newInstance(it))
                        .commit()

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment, AlphabetsDetailsFragment.newInstance(it[0]))
                        .commit()
                })
            }
            R.id.hamsado -> {
                vm.getHamsado().observe(this, {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, AlphabetsFragment.newInstance(it))
                        .commit()

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment, AlphabetsDetailsFragment.newInstance(it[0]))
                        .commit()


                })


            }
            R.id.sadonok -> {
                vm.getSadonok().observe(this, {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, AlphabetsFragment.newInstance(it))
                        .commit()

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment, AlphabetsDetailsFragment.newInstance(it[0]))
                        .commit()

                })
            }
            R.id.yodbarsar -> {
                vm.getYodbarsar().observe(this, {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, AlphabetsFragment.newInstance(it))
                        .commit()

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment, AlphabetsDetailsFragment.newInstance(it[0]))
                        .commit()

                })
            }
        }
        return true
    }

}