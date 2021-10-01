package com.encom.dynamicview.vm

import androidx.lifecycle.ViewModel
import com.encom.dynamicview.repository.AlphabetMainCviewRepository
import com.encom.dynamicview.repository.model.AlphabetButtonModel

/**
 * Created by ABDUAHAD FAIZULLOEV on 26,сентябрь,2021
 * abduahad.fayzulloev@gmail.com
 * http://abduahad.com/
 *
 */
class AlphabetMainCviewViewModel:ViewModel(){
   private val cviewRepositoryAlphabet:AlphabetMainCviewRepository = AlphabetMainCviewRepository()

   fun getAlphabets():ArrayList<AlphabetButtonModel>{
       return cviewRepositoryAlphabet.getAlphabet()
   }
}