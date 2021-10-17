package com.example.tajikenglish.Order.Repository

import android.content.Context
import com.example.tajikenglish.Order.Model.OrderModel
import com.example.tajikenglish.R

class OrderRepository(context: Context) {

    fun getAlphabet(): ArrayList<OrderModel> {
        val users: ArrayList<OrderModel> = ArrayList()
        users.add(OrderModel(0, "rasmho/anor.jpg"))
        users.add(OrderModel(0, "rasmho/anor.jpg"))
        users.add(OrderModel(0, "rasmho/anor.jpg"))
        users.add(OrderModel(0, "rasmho/anor.jpg"))
        users.add(OrderModel(0, "rasmho/anor.jpg"))

        return users
    }

}