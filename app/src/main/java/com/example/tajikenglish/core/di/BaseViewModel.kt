package com.example.tajikenglish.core.di

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tajikenglish.repository.MainRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

open class BaseViewModel : ViewModel(), KoinComponent {
    protected val isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    protected val repository: MainRepository by inject()


          fun getLoading(): LiveData<Boolean> = isLoading

    var testalphabet = repository.getAlphabetTest()

    var testharfyobi = repository.getHarfyobiTest()
}