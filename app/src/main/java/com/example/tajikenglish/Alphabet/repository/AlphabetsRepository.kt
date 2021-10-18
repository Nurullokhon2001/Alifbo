package com.example.tajikenglish.Alphabet.repository

import android.annotation.SuppressLint
import android.content.Context
import com.example.tajikenglish.Alphabet.repository.model.AlphabetsModel
import com.example.tajikenglish.MySqlOpenHelper.MySQLiteOpenHelper

class AlphabetsRepository(context: Context) : MySQLiteOpenHelper(context)  {

    @SuppressLint("Range")
    fun getAlphabet(): ArrayList<AlphabetsModel> {
        val array: ArrayList<AlphabetsModel> = ArrayList()
        val sql = "SELECT * FROM AlfabetsData"
        val mCursor = Query(sql)
        if (mCursor != null) {
            if (mCursor.moveToFirst()) {
                do {
                    val id = mCursor.getInt(mCursor.getColumnIndex("id"))
                    val alfabet = mCursor.getString(mCursor.getColumnIndex("alfabet"))
                    val word = mCursor.getString(mCursor.getColumnIndex("word"))
                    val image = mCursor.getString(mCursor.getColumnIndex("image"))
                    val alfabetPlayer = mCursor.getString(mCursor.getColumnIndex("alfabetplayer"))
                    val imagePlayer = mCursor.getString(mCursor.getColumnIndex("imageplager"))
                    val category = mCursor.getInt(mCursor.getColumnIndex("category"))
                    array.add(AlphabetsModel(id,alfabet,word,image,alfabetPlayer,imagePlayer,category))
                } while (mCursor.moveToNext())
            }
            mCursor.close()
        }
        return array
    }

    @SuppressLint("Range")
    fun getHamsado(): ArrayList<AlphabetsModel> {
        val array: ArrayList<AlphabetsModel> = ArrayList()
        val sql = "SELECT * FROM AlfabetsData Where category=2"
        val mCursor = Query(sql)
        if (mCursor != null) {
            if (mCursor.moveToFirst()) {
                do {
                    val id = mCursor.getInt(mCursor.getColumnIndex("id"))
                    val alfabet = mCursor.getString(mCursor.getColumnIndex("alfabet"))
                    val word = mCursor.getString(mCursor.getColumnIndex("word"))
                    val image = mCursor.getString(mCursor.getColumnIndex("image"))
                    val alfabetPlayer = mCursor.getString(mCursor.getColumnIndex("alfabetplayer"))
                    val imagePlayer = mCursor.getString(mCursor.getColumnIndex("imageplager"))
                    val category = mCursor.getInt(mCursor.getColumnIndex("category"))
                    array.add(AlphabetsModel(id,alfabet,word,image,alfabetPlayer,imagePlayer,category))
                } while (mCursor.moveToNext())
            }
            mCursor.close()
        }
        return array
    }

    @SuppressLint("Range")
    fun getSadonok(): ArrayList<AlphabetsModel> {
        val array: ArrayList<AlphabetsModel> = ArrayList()
        val sql = "SELECT * FROM AlfabetsData Where category=1"
        val mCursor = Query(sql)
        if (mCursor != null) {
            if (mCursor.moveToFirst()) {
                do {
                    val id = mCursor.getInt(mCursor.getColumnIndex("id"))
                    val alfabet = mCursor.getString(mCursor.getColumnIndex("alfabet"))
                    val word = mCursor.getString(mCursor.getColumnIndex("word"))
                    val image = mCursor.getString(mCursor.getColumnIndex("image"))
                    val alfabetPlayer = mCursor.getString(mCursor.getColumnIndex("alfabetplayer"))
                    val imagePlayer = mCursor.getString(mCursor.getColumnIndex("imageplager"))
                    val category = mCursor.getInt(mCursor.getColumnIndex("category"))
                    array.add(AlphabetsModel(id,alfabet,word,image,alfabetPlayer,imagePlayer,category))
                } while (mCursor.moveToNext())
            }
            mCursor.close()
        }
        return array
    }

    @SuppressLint("Range")
    fun getYodbarsar(): ArrayList<AlphabetsModel> {
        val array: ArrayList<AlphabetsModel> = ArrayList()
        val sql = "SELECT * FROM AlfabetsData Where category=3"
        val mCursor = Query(sql)
        if (mCursor != null) {
            if (mCursor.moveToFirst()) {
                do {
                    val id = mCursor.getInt(mCursor.getColumnIndex("id"))
                    val alfabet = mCursor.getString(mCursor.getColumnIndex("alfabet"))
                    val word = mCursor.getString(mCursor.getColumnIndex("word"))
                    val image = mCursor.getString(mCursor.getColumnIndex("image"))
                    val alfabetPlayer = mCursor.getString(mCursor.getColumnIndex("alfabetplayer"))
                    val imagePlayer = mCursor.getString(mCursor.getColumnIndex("imageplager"))
                    val category = mCursor.getInt(mCursor.getColumnIndex("category"))
                    array.add(AlphabetsModel(id,alfabet,word,image,alfabetPlayer,imagePlayer,category))
                } while (mCursor.moveToNext())
            }
            mCursor.close()
        }
        return array
    }
















}