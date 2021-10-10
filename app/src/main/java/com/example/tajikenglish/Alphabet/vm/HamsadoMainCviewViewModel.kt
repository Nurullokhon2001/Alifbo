package com.encom.dynamicview.vm

import androidx.lifecycle.ViewModel
import com.encom.dynamicview.repository.AlphabetMainCviewRepository
import com.encom.dynamicview.repository.HamsadoMainCviewRepository
import com.encom.dynamicview.repository.model.AlphabetButtonModel

class HamsadoMainCviewViewModel:ViewModel(){
   private val cviewRepositoryAlphabet:HamsadoMainCviewRepository = HamsadoMainCviewRepository()

   fun getAlphabets():ArrayList<AlphabetButtonModel>{
       return cviewRepositoryAlphabet.getAlphabet()
   }
}