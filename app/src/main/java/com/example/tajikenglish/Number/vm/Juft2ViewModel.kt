package com.encom.dynamicview.vm

import androidx.lifecycle.ViewModel
import com.encom.dynamicview.repository.AlphabetMainCviewRepository
import com.encom.dynamicview.repository.HamsadoMainCviewRepository
import com.encom.dynamicview.repository.Juft2Repository
import com.encom.dynamicview.repository.SadonokMainCviewRepository
import com.encom.dynamicview.repository.model.AlphabetButtonModel

/**
 * Created by ABDUAHAD FAIZULLOEV on 26,сентябрь,2021
 * abduahad.fayzulloev@gmail.com
 * http://abduahad.com/
 *
 */
class Juft2ViewModel:ViewModel(){
   private val cviewRepositoryAlphabet:Juft2Repository = Juft2Repository()

   fun getAlphabets():ArrayList<AlphabetButtonModel>{
       return cviewRepositoryAlphabet.getAlphabet()
   }
}