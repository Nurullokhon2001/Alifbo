package com.example.tajikenglish.alphabet.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tajikenglish.modules.models.AlphabetsModel
import com.example.tajikenglish.core.di.BaseViewModel

class AlphabetsViewModel() : BaseViewModel() {


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