package com.encom.dynamicview.vm

import androidx.lifecycle.ViewModel
import com.encom.dynamicview.repository.model.AlphabetImageModel
import com.encom.dynamicview.repository.model.AlphabetImageRepository

/**
 * Created by ABDUAHAD FAIZULLOEV on 26,сентябрь,2021
 * abduahad.fayzulloev@gmail.com
 * http://abduahad.com/
 *
 */
class AlphabetImageViewModel:ViewModel(){
   private val repository:AlphabetImageRepository = AlphabetImageRepository()

   fun getAlphabets(getIndexArray : Int):AlphabetImageModel{
       return repository.getAlphabet()[getIndexArray]
   }




}