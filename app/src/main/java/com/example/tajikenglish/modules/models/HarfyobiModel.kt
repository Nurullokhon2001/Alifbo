package com.example.tajikenglish.modules.models

data class HarfyobiModel (
    val id: Int,
    val question: String,
    val icon: String,
    val speech: String,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctAnswer: Int
    )
