package com.example.tajikenglish.Alphabet.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tajikenglish.Alphabet.repository.AlphabetsRepository
import com.example.tajikenglish.Alphabet.repository.model.AlphabetsModel

class AlphabetsViewModel(application: Application) : AndroidViewModel(application) {

    val repository: AlphabetsRepository

    init {
        repository = AlphabetsRepository(application)
    }
    var   myDataSet = repository.getAlphabet()
    fun fetchAlphabet(): LiveData<ArrayList<AlphabetsModel>> {
        val result: MutableLiveData<ArrayList<AlphabetsModel>> = MutableLiveData()
        result.postValue(myDataSet)
        return result
    }
}