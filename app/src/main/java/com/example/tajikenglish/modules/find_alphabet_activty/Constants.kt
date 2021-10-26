package com.example.tajikenglish.modules.find_alphabet_activty

import com.example.tajikenglish.core.di.BaseViewModel


object Constants  {


    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"






    fun getQuestions(): ArrayList<Question> {

        var baseViewModel : BaseViewModel = BaseViewModel()
        var array = baseViewModel.testalphabet
       var  testarray : ArrayList<Question> = ArrayList()

        array.shuffle()
        var a = 0
        while (a<10){
            testarray.add(array[a])
            a++
        }

        return testarray


    }
}


