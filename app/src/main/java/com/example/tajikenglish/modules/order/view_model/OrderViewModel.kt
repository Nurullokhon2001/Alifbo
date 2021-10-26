package com.example.tajikenglish.order.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tajikenglish.core.di.BaseViewModel

import com.example.tajikenglish.modules.models.OrderModel

class OrderViewModel : BaseViewModel() {



    fun getAlphabet(): LiveData<ArrayList<OrderModel>> {
        val myDataSet = repository.getOrderAlphabet()
        val result: MutableLiveData<ArrayList<OrderModel>> = MutableLiveData()
        result.postValue(myDataSet)
        return result
    }
}






