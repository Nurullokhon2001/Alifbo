package com.encom.dynamicview.vm

import androidx.lifecycle.ViewModel
import com.encom.dynamicview.repository.model.AlphabetImageModel
import com.encom.dynamicview.repository.model.AlphabetImageRepository


class AlphabetDrawViewModel:ViewModel(){
   private val repository:AlphabetImageRepository = AlphabetImageRepository()

   fun getAlphabets(getIndexArray : Int):AlphabetImageModel{
       return repository.getAlphabet()[getIndexArray]
   }




}