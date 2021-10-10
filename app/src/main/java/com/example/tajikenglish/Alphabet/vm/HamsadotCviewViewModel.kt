package com.encom.dynamicview.vm

import androidx.lifecycle.ViewModel
import com.encom.dynamicview.repository.model.AlphabetImageWordModel
import com.example.tajikenglish.Alphabet.repository.HamsadoRepository

class HamsadotCviewViewModel:ViewModel(){
   private val repository: HamsadoRepository = HamsadoRepository()

   fun getAlphabets(getIndexArray : Int):AlphabetImageWordModel{
       return repository.getAlphabet()[getIndexArray]
   }




}