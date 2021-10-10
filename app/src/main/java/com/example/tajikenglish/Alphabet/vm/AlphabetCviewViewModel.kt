package com.encom.dynamicview.vm

import androidx.lifecycle.ViewModel
import com.encom.dynamicview.repository.model.AlphabetImageWordModel
import com.example.tajikenglish.Alphabet.repository.AlphabetRepository

class AlphabetCviewViewModel:ViewModel(){
   private val repository: AlphabetRepository = AlphabetRepository()

   fun getAlphabets(getIndexArray : Int):AlphabetImageWordModel{
       return repository.getAlphabet()[getIndexArray]
   }




}