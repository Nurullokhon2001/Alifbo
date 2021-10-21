package com.encom.dynamicview.vm


import com.example.tajikenglish.modules.DrawImageModel
import com.example.tajikenglish.modules.DrawModel
import com.example.tajikenglish.core.di.BaseViewModel


class DrawViewModel:BaseViewModel(){


   fun getAlphabets():ArrayList<DrawModel>{
       return repository.getDrawAlphabets()
   }

    fun getDrawAlphabetsImage(getIndexArray : Int): DrawImageModel {
        return repository.getDrawAlphabetsImage()[getIndexArray]
    }

}