package com.example.tajikenglish.Number

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.example.tajikenglish.Alphabet.view.AlphabetsDetailsFragment
import com.example.tajikenglish.Alphabet.view.AlphabetsFragment
import com.example.tajikenglish.MainActivity
import com.example.tajikenglish.Number.vm.NumberViewModel
import com.example.tajikenglish.R
import com.example.tajikenglish.Alphabet.repository.model.AlphabetsModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class NumberActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {
    lateinit var bottomNavigationView: BottomNavigationView

    private lateinit var vm: NumberViewModel
    private var numbersArray: ArrayList<AlphabetsModel> = ArrayList()
    private var toqArray: ArrayList<AlphabetsModel> =   ArrayList()
    private var juftArray: ArrayList<AlphabetsModel> =   ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number)


        vm = ViewModelProvider(this).get(NumberViewModel::class.java)
        vm.getAlphabet().observe(this, {
            numbersArray=it
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, AlphabetsFragment.newInstance(it))
                .commit()

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, AlphabetsDetailsFragment.newInstance(it[0]))
                .commit()
        })

        vm.getHamsado().observe(this, {
            toqArray=it

        })

        vm.getSadonok().observe(this, {
            juftArray=it

        })




        val toolbar  : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
           val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener(this)

//

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.number -> {
                vm.getAlphabet().observe(this, {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, AlphabetsFragment.newInstance(it))
                        .commit()

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment, AlphabetsDetailsFragment.newInstance(it[0]))
                        .commit()
                })
            }
            R.id.toq -> {
                vm.getHamsado().observe(this, {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, AlphabetsFragment.newInstance(it))
                        .commit()

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment, AlphabetsDetailsFragment.newInstance(it[0]))
                        .commit()


                })

            }
            R.id.juft -> {
                vm.getSadonok().observe(this, {
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