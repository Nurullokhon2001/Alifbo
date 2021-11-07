package com.example.tajikenglish.modules.find_alphabet_activty

import com.example.tajikenglish.core.di.BaseViewModel
import com.example.tajikenglish.modules.models.TestModel


object TestConstants  {


    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"




    fun getQuestions(): ArrayList<TestModel> {

        var baseViewModel : BaseViewModel = BaseViewModel()
        var array = baseViewModel.testalphabet
       var  testarray : ArrayList<TestModel> = ArrayList()

        array.shuffle()
        var a = 0
        while (a<10){
            testarray.add(array[a])
            a++
        }

        return testarray


    }
}


