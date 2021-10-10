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


    fun getAlphabet(): LiveData<ArrayList<AlphabetsModel>> {
        val myDataSet = repository.getAlphabet()
        val result: MutableLiveData<ArrayList<AlphabetsModel>> = MutableLiveData()
        result.postValue(myDataSet)
        return result
    }




    fun getHamsado(): LiveData<ArrayList<AlphabetsModel>> {
        val myDataSet = repository.getHamsado()
        val result: MutableLiveData<ArrayList<AlphabetsModel>> = MutableLiveData()
        result.postValue(myDataSet)
        return result
    }

    fun getSadonok(): LiveData<ArrayList<AlphabetsModel>> {
        val myDataSet = repository.getSadonok()
        val result: MutableLiveData<ArrayList<AlphabetsModel>> = MutableLiveData()
        result.postValue(myDataSet)
        return result
    }

    fun getYodbarsar(): LiveData<ArrayList<AlphabetsModel>> {
        val myDataSet = repository.getYodbarsar()
        val result: MutableLiveData<ArrayList<AlphabetsModel>> = MutableLiveData()
        result.postValue(myDataSet)
        return result
    }



}