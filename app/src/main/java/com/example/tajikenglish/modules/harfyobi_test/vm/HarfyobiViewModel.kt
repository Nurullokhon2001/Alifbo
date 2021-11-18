package com.example.tajikenglish.modules.harfyobi_test.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tajikenglish.core.di.BaseViewModel
import com.example.tajikenglish.modules.models.HarfyobiModel

class HarfyobiViewModel : BaseViewModel() {


    fun getHarfyobi(): LiveData<ArrayList<HarfyobiModel>> {
        val harfyobiarray: MutableLiveData<ArrayList<HarfyobiModel>> = MutableLiveData()
        val array = repository.getHarfyobiTest()
        array.shuffle()
        val testarray: ArrayList<HarfyobiModel> = ArrayList()
        var a = 0
        while (a < 10) {
            testarray.add(array[a])
            a++
        }
        harfyobiarray.postValue(testarray)
        return harfyobiarray
    }
}