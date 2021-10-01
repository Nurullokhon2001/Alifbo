package com.encom.dynamicview.vm

import androidx.lifecycle.ViewModel
import com.encom.dynamicview.repository.Juft2Repository
import com.encom.dynamicview.repository.model.AlphabetImageWordModel
import com.example.tajikenglish.Alphabet.repository.HamsadoRepository
import com.example.tajikenglish.Alphabet.repository.SadonokRepository
import com.example.tajikenglish.Number.repository.JuftRepository

/**
 * Created by ABDUAHAD FAIZULLOEV on 26,сентябрь,2021
 * abduahad.fayzulloev@gmail.com
 * http://abduahad.com/
 *
 */
class JuftViewModel:ViewModel(){
   private val repository: JuftRepository = JuftRepository()

   fun getAlphabets(getIndexArray : Int):AlphabetImageWordModel{
       return repository.getAlphabet()[getIndexArray]
   }




}