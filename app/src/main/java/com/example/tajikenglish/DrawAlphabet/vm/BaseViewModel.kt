package com.example.tajikenglish.DrawAlphabet.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tajikenglish.DrawAlphabet.repository.DrawRepository

open  class BaseViewModel (application: Application) : AndroidViewModel(application) {
    val repository: DrawRepository

    init {
        repository = DrawRepository(application)
    }


}