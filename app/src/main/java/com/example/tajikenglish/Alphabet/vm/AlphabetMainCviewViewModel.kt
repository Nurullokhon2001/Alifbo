package com.encom.dynamicview.vm

import androidx.lifecycle.ViewModel
import com.encom.dynamicview.repository.AlphabetMainCviewRepository
import com.encom.dynamicview.repository.model.AlphabetButtonModel

class AlphabetMainCviewViewModel:ViewModel(){
   private val cviewRepositoryAlphabet:AlphabetMainCviewRepository = AlphabetMainCviewRepository()

   fun getAlphabets():ArrayList<AlphabetButtonModel>{
       return cviewRepositoryAlphabet.getAlphabet()
   }
}