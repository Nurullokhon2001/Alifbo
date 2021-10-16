package com.example.tajikenglish.Order.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.example.tajikenglish.Order.Model.OrderModel
import com.example.tajikenglish.Order.Repository.OrderRepository

class OrderViewModel (application: Application) : AndroidViewModel(application) {

    val repository: OrderRepository

    init {
        repository = OrderRepository(application)
    }


    fun getAlphabet(): LiveData<ArrayList<OrderModel>> {
        val myDataSet = repository.getAlphabet()
        val result: MutableLiveData<ArrayList<OrderModel>> = MutableLiveData()
        result.postValue(myDataSet)
        return result
    }
}






