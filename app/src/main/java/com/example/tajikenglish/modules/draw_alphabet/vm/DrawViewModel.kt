package com.encom.dynamicview.vm


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tajikenglish.modules.models.DrawImageModel
import com.example.tajikenglish.modules.models.DrawModel
import com.example.tajikenglish.core.di.BaseViewModel
import com.example.tajikenglish.modules.models.AlphabetsModel


class DrawViewModel:BaseViewModel(){

//
//   fun getAlphabets():ArrayList<DrawModel>{
//       return repository.getDrawAlphabets()
//   }


    fun getAlphabets(): LiveData<ArrayList<DrawModel>> {
        val myDataSet = repository.getDrawAlphabets()
        val result: MutableLiveData<ArrayList<DrawModel>> = MutableLiveData()
        result.postValue(myDataSet)
        return result
    }



}