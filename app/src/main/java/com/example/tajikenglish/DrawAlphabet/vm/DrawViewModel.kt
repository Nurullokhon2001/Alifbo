package com.example.tajikenglish.DrawAlphabet.vm

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tajikenglish.DrawAlphabet.repository.drawData

class DrawViewModel(application: Application) : BaseViewModel(application) {

    var myDataSet: ArrayList<drawData> = ArrayList()

    fun fetchDictionaries(): LiveData<ArrayList<drawData>> {
        val result: MutableLiveData<ArrayList<drawData>> = MutableLiveData()
//        viewModelScope.launch {
//
//            myDataSet = repository.getDictionaries()
//            result.postValue(myDataSet)
//
//        }

        myDataSet = repository.getDictionaries()
          result.value=myDataSet

        return result
    }



}