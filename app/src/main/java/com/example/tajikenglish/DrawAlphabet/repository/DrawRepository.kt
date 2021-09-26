package com.example.tajikenglish.DrawAlphabet.repository

import android.annotation.SuppressLint
import android.app.DownloadManager
import android.content.Context
import com.encom.rus_taj.repository.MySQLiteOpenHelper

class DrawRepository (context: Context) : MySQLiteOpenHelper(context) {

    @SuppressLint("Range")
    fun getDictionaries(): ArrayList<drawData> {
        val array: ArrayList<drawData> = ArrayList()
        val sql = "SELECT * FROM drawalphabet"
        val mCursor = Query(sql)
        if (mCursor != null) {
            if (mCursor.moveToFirst()) {
                do {
                    val id = mCursor.getInt(mCursor.getColumnIndex("id"))
                    val image = mCursor.getString(mCursor.getColumnIndex("alphabetimage"))

                    array.add(drawData(id, image))
                } while (mCursor.moveToNext())
            }
            mCursor.close()
        }
        return array
    }
}