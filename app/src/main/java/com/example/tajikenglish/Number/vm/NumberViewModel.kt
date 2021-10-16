package com.example.tajikenglish.Number.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tajikenglish.Number.Model.NumbersModel
import com.example.tajikenglish.Number.Repository.NumbersRepository

class NumberViewModel (application: Application) : AndroidViewModel(application) {

    val repository: NumbersRepository

    init {
        repository = NumbersRepository(application)
    }


    fun getNumber(): LiveData<ArrayList<NumbersModel>> {
        val myDataSet = repository.getNumber()
        val result: MutableLiveData<ArrayList<NumbersModel>> = MutableLiveData()
        result.postValue(myDataSet)
        return result
    }




    fun getToq(): LiveData<ArrayList<NumbersModel>> {
        val myDataSet = repository.getToq()
        val result: MutableLiveData<ArrayList<NumbersModel>> = MutableLiveData()
        result.postValue(myDataSet)
        return result
    }

    fun getJuft(): LiveData<ArrayList<NumbersModel>> {
        val myDataSet = repository.getJuft()
        val result: MutableLiveData<ArrayList<NumbersModel>> = MutableLiveData()
        result.postValue(myDataSet)
        return result
    }


}