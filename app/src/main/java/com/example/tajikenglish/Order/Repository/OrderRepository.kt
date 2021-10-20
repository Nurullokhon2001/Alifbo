package com.example.tajikenglish.Order.Repository

import android.annotation.SuppressLint
import android.content.Context
import com.example.tajikenglish.Alphabet.repository.model.AlphabetsModel
import com.example.tajikenglish.MySqlOpenHelper.MySQLiteOpenHelper
import com.example.tajikenglish.Order.Model.OrderModel
import com.example.tajikenglish.R

class OrderRepository(context: Context):MySQLiteOpenHelper(context) {

    @SuppressLint("Range")
    fun getAlphabet(): ArrayList<OrderModel> {
        val array: ArrayList<OrderModel> = ArrayList()
        val sql = "SELECT * from Order7"
        val mCursor = Query(sql)
        if (mCursor != null) {
            if (mCursor.moveToFirst()) {
                do {
                    val id = mCursor.getInt(mCursor.getColumnIndex("id"))
                    val alfabet = mCursor.getString(mCursor.getColumnIndex("Alphabet"))

                    array.add(OrderModel(id,alfabet))
                } while (mCursor.moveToNext())
            }
            mCursor.close()
        }
        return array

    }

}