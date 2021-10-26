package com.example.tajikenglish.modules.find_alphabet_activty

data class Question(
    val id: Int,
    val question: String,
    val speech: String,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctAnswer: Int
)