package com.example.tajikenglish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tajikenglish.main_menu.view.MainFragment
import com.example.tajikenglish.core.di.ApplicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startKoin {
            androidContext(application)
            modules(ApplicationModule.applicationModule)
        }

        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.container, MainFragment()).commit()
    }


}