package com.encom.dynamicview.vm

import androidx.lifecycle.ViewModel
import com.encom.dynamicview.repository.AlphabetDrawButtonRepository
import com.encom.dynamicview.repository.model.AlphabetModel

/**
 * Created by ABDUAHAD FAIZULLOEV on 26,сентябрь,2021
 * abduahad.fayzulloev@gmail.com
 * http://abduahad.com/
 *
 */
class MainViewModel:ViewModel(){
   private val repository:AlphabetDrawButtonRepository = AlphabetDrawButtonRepository()

   fun getAlphabets():ArrayList<AlphabetModel>{
       return repository.getAlphabet()
   }
}