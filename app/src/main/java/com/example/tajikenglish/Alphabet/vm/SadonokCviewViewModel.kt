package com.encom.dynamicview.vm

import androidx.lifecycle.ViewModel
import com.encom.dynamicview.repository.model.AlphabetImageWordModel
import com.example.tajikenglish.Alphabet.repository.HamsadoRepository
import com.example.tajikenglish.Alphabet.repository.SadonokRepository

class SadonokCviewViewModel:ViewModel(){
   private val repository: SadonokRepository = SadonokRepository()

   fun getAlphabets(getIndexArray : Int):AlphabetImageWordModel{
       return repository.getAlphabet()[getIndexArray]
   }




}