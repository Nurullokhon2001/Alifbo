package com.example.tajikenglish.Order.Repository

import android.content.Context
import com.example.tajikenglish.Order.Model.OrderModel
import com.example.tajikenglish.R

class OrderRepository(context: Context) {

    fun getAlphabet(): ArrayList<OrderModel> {
        val array: ArrayList<OrderModel> = ArrayList()
        array.add(OrderModel(0, R.drawable.abc))

        return array
    }

}