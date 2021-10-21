package com.example.tajikenglish.number

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.example.tajikenglish.MainActivity
import com.example.tajikenglish.modules.NumbersModel
import com.example.tajikenglish.number.view.NumbersDetailsFragment
import com.example.tajikenglish.number.view.NumbersFragment
import com.example.tajikenglish.number.vm.NumberViewModel
import com.example.tajikenglish.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class NumberActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {
    lateinit var bottomNavigationView: BottomNavigationView

    private lateinit var vm: NumberViewModel
    private var numbersArray: ArrayList<NumbersModel> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number)


        vm = ViewModelProvider(this).get(NumberViewModel::class.java)
        vm.getNumber().observe(this, {
            numbersArray=it
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, NumbersFragment.newInstance(it))
                .commit()

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, NumbersDetailsFragment.newInstance(it[0]))
                .commit()
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
                vm.getNumber().observe(this, {
                numbersArray=it
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, NumbersFragment.newInstance(it))
                    .commit()

                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment, NumbersDetailsFragment.newInstance(it[0]))
                    .commit()
            })

            }
            R.id.toq -> {
                vm.getToq().observe(this, {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, NumbersFragment.newInstance(it))
                        .commit()

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment, NumbersDetailsFragment.newInstance(it[0]))
                        .commit()

                })


            }
            R.id.juft -> {
                vm.getJuft().observe(this, {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, NumbersFragment.newInstance(it))
                        .commit()

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment, NumbersDetailsFragment.newInstance(it[0]))
                        .commit()

                })
            }
            }


        return true
    }
}