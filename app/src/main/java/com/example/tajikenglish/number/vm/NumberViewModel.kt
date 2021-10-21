package com.example.tajikenglish.number.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tajikenglish.core.di.BaseViewModel
import com.example.tajikenglish.modules.NumbersModel

class NumberViewModel : BaseViewModel(){




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