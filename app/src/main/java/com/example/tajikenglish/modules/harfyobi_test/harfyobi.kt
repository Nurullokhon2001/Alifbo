package com.example.tajikenglish.modules.harfyobi_test

import com.example.tajikenglish.core.di.BaseViewModel
import com.example.tajikenglish.modules.find_alphabet_activty.Question

object harfyobi {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"


    fun getQuestions(): ArrayList<HarfyobiModel> {

        var baseViewModel : BaseViewModel = BaseViewModel()
        var array = baseViewModel.testharfyobi
        var  testarray : ArrayList<HarfyobiModel> = ArrayList()

        array.shuffle()
        var a = 0
        while (a<10){
            testarray.add(array[a])
            a++
        }

        return testarray


    }
}