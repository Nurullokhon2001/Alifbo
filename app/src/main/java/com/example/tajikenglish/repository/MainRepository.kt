package com.example.tajikenglish.repository

import com.example.tajikenglish.find_alphabet_activty.Question
import com.example.tajikenglish.modules.DrawImageModel
import com.example.tajikenglish.modules.DrawModel
import com.example.tajikenglish.modules.AlphabetsModel
import com.example.tajikenglish.modules.drawsModel
import com.example.tajikenglish.modules.NumbersModel
import com.example.tajikenglish.modules.OrderModel

interface MainRepository {
    fun getMenu(): ArrayList<drawsModel>
    fun getAlphabet(): ArrayList<AlphabetsModel>
    fun getHamsado(): ArrayList<AlphabetsModel>
    fun getSadonok(): ArrayList<AlphabetsModel>
    fun getYodbarsar(): ArrayList<AlphabetsModel>
    fun getDrawAlphabets(): ArrayList<DrawModel>
    fun getDrawAlphabetsImage(): ArrayList<DrawImageModel>
    fun getNumber(): ArrayList<NumbersModel>
    fun getToq(): ArrayList<NumbersModel>
    fun getJuft(): ArrayList<NumbersModel>
    fun getOrderAlphabet(): ArrayList<OrderModel>
    fun getAlphabetTest(): ArrayList<Question>

}