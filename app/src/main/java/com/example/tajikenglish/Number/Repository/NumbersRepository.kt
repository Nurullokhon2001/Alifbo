package com.example.tajikenglish.Number.Repository

import android.annotation.SuppressLint
import android.content.Context
import com.example.tajikenglish.MySqlOpenHelper.MySQLiteOpenHelper
import com.example.tajikenglish.Number.Model.NumbersModel

class NumbersRepository(context: Context) : MySQLiteOpenHelper(context) {

    @SuppressLint("Range")
    fun getNumber(): ArrayList<NumbersModel> {
        val array: ArrayList<NumbersModel> = ArrayList()
        val sql = "SELECT * FROM NumbersData"
        val mCursor = Query(sql)
        if (mCursor != null) {
            if (mCursor.moveToFirst()) {
                do {
                    val id = mCursor.getInt(mCursor.getColumnIndex("id"))
                    val alfabet = mCursor.getInt(mCursor.getColumnIndex("number"))
                    val word = mCursor.getString(mCursor.getColumnIndex("word"))
                    val image = mCursor.getString(mCursor.getColumnIndex("image"))
                    val alfabetPlayer = mCursor.getString(mCursor.getColumnIndex("numberplayer"))
                    val imagePlayer = mCursor.getString(mCursor.getColumnIndex("imageplayer"))
                    val category = mCursor.getInt(mCursor.getColumnIndex("category"))
                    array.add(NumbersModel(id,alfabet,word,image,alfabetPlayer,imagePlayer,category))
                } while (mCursor.moveToNext())
            }
            mCursor.close()
        }
        return array
    }
    @SuppressLint("Range")
    fun getToq(): ArrayList<NumbersModel> {
        val array: ArrayList<NumbersModel> = ArrayList()
        val sql = "SELECT * FROM NumbersData Where category=1"
        val mCursor = Query(sql)
        if (mCursor != null) {
            if (mCursor.moveToFirst()) {
                do {
                    val id = mCursor.getInt(mCursor.getColumnIndex("id"))
                    val alfabet = mCursor.getInt(mCursor.getColumnIndex("number"))
                    val word = mCursor.getString(mCursor.getColumnIndex("word"))
                    val image = mCursor.getString(mCursor.getColumnIndex("image"))
                    val alfabetPlayer = mCursor.getString(mCursor.getColumnIndex("numberplayer"))
                    val imagePlayer = mCursor.getString(mCursor.getColumnIndex("imageplayer"))
                    val category = mCursor.getInt(mCursor.getColumnIndex("category"))
                    array.add(NumbersModel(id,alfabet,word,image,alfabetPlayer,imagePlayer,category))
                } while (mCursor.moveToNext())
            }
            mCursor.close()
        }
        return array
    }

    @SuppressLint("Range")
    fun getJuft(): ArrayList<NumbersModel> {
        val array: ArrayList<NumbersModel> = ArrayList()
        val sql = "SELECT * FROM NumbersData Where category=2 "
        val mCursor = Query(sql)
        if (mCursor != null) {
            if (mCursor.moveToFirst()) {
                do {
                    val id = mCursor.getInt(mCursor.getColumnIndex("id"))
                    val alfabet = mCursor.getInt(mCursor.getColumnIndex("number"))
                    val word = mCursor.getString(mCursor.getColumnIndex("word"))
                    val image = mCursor.getString(mCursor.getColumnIndex("image"))
                    val alfabetPlayer = mCursor.getString(mCursor.getColumnIndex("numberplayer"))
                    val imagePlayer = mCursor.getString(mCursor.getColumnIndex("imageplayer"))
                    val category = mCursor.getInt(mCursor.getColumnIndex("category"))
                    array.add(NumbersModel(id,alfabet,word,image,alfabetPlayer,imagePlayer,category))
                } while (mCursor.moveToNext())
            }
            mCursor.close()
        }
        return array
    }


}