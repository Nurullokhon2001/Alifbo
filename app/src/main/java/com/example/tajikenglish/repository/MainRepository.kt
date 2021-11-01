package com.example.tajikenglish.repository

import com.example.tajikenglish.modules.models.TestModel
import com.example.tajikenglish.modules.models.DrawModel
import com.example.tajikenglish.modules.models.AlphabetsModel
import com.example.tajikenglish.modules.drawsModel
import com.example.tajikenglish.modules.models.HarfyobiModel
import com.example.tajikenglish.modules.models.NumbersModel
import com.example.tajikenglish.modules.models.OrderModel

interface MainRepository {
    fun getMenu(): ArrayList<drawsModel>
    fun getAlphabet(): ArrayList<AlphabetsModel>
    fun getHamsado(): ArrayList<AlphabetsModel>
    fun getSadonok(): ArrayList<AlphabetsModel>
    fun getYodbarsar(): ArrayList<AlphabetsModel>
    fun getDrawAlphabets(): ArrayList<DrawModel>
    fun getNumber(): ArrayList<NumbersModel>
    fun getToq(): ArrayList<NumbersModel>
    fun getJuft(): ArrayList<NumbersModel>
    fun getOrderAlphabet(): ArrayList<OrderModel>
    fun getAlphabetTest(): ArrayList<TestModel>
    fun getHarfyobiTest(): ArrayList<HarfyobiModel>


}