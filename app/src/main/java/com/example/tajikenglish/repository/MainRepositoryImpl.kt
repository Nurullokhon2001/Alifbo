package com.example.tajikenglish.repository

import android.annotation.SuppressLint
import android.content.Context
import com.example.tajikenglish.modules.models.DrawImageModel
import com.example.tajikenglish.modules.models.DrawModel
import com.example.tajikenglish.modules.drawsModel
import com.example.tajikenglish.R
import com.example.tajikenglish.modules.find_alphabet_activty.Question
import com.example.tajikenglish.modules.harfyobi_test.HarfyobiModel
import com.example.tajikenglish.modules.models.AlphabetsModel
import com.example.tajikenglish.my_sql_open_helper.MySQLiteOpenHelper
import com.example.tajikenglish.modules.models.NumbersModel
import com.example.tajikenglish.modules.models.OrderModel

class MainRepositoryImpl(val context: Context) : MainRepository, MySQLiteOpenHelper(context) {

    override fun getMenu(): ArrayList<drawsModel> {
        val arrayList: ArrayList<drawsModel> = ArrayList()
        arrayList.add(drawsModel(ALIFBO, R.drawable.abc, "Алифбо", R.color.alifbo))
        arrayList.add(drawsModel(RAQAMHO, R.drawable.numbers, "Рақамхо", R.color.raqam))
        arrayList.add(drawsModel(RASMKASHI, R.drawable.words, "Расмкаши", R.color.rasmkashi))
        arrayList.add(drawsModel(TARTIB, R.drawable.phrases, "Тартиб", R.color.tartib))
        arrayList.add(drawsModel(KALIMASOZI, R.drawable.topic, "Тест", R.color.kalimasozi))
        arrayList.add(drawsModel(KALIMAYOBI, R.drawable.quiz, "Харфрёбак", R.color.kalimayobi))
        return arrayList
    }


    @SuppressLint("Range")
    override fun getAlphabet(): ArrayList<AlphabetsModel> {
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
                    array.add(AlphabetsModel(id,
                        alfabet,
                        word,
                        image,
                        alfabetPlayer,
                        imagePlayer,
                        category))
                } while (mCursor.moveToNext())
            }
            mCursor.close()
        }
        return array
    }

    @SuppressLint("Range")
    override fun getHamsado(): ArrayList<AlphabetsModel> {
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
                    array.add(AlphabetsModel(id,
                        alfabet,
                        word,
                        image,
                        alfabetPlayer,
                        imagePlayer,
                        category))
                } while (mCursor.moveToNext())
            }
            mCursor.close()
        }
        return array
    }

    @SuppressLint("Range")
    override fun getSadonok(): ArrayList<AlphabetsModel> {
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
                    array.add(AlphabetsModel(id,
                        alfabet,
                        word,
                        image,
                        alfabetPlayer,
                        imagePlayer,
                        category))
                } while (mCursor.moveToNext())
            }
            mCursor.close()
        }
        return array
    }

    @SuppressLint("Range")
    override fun getYodbarsar(): ArrayList<AlphabetsModel> {
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
                    array.add(AlphabetsModel(id,
                        alfabet,
                        word,
                        image,
                        alfabetPlayer,
                        imagePlayer,
                        category))
                } while (mCursor.moveToNext())
            }
            mCursor.close()
        }
        return array
    }


    @SuppressLint("Range")
    override fun getDrawAlphabets(): ArrayList<DrawModel> {
        val array: ArrayList<DrawModel> = ArrayList()
        val sql = "SELECT * FROM DrawAlphabet order by id"
        val mCursor = Query(sql)
        if (mCursor != null) {
            if (mCursor.moveToFirst()) {
                do {
                    val id = mCursor.getInt(mCursor.getColumnIndex("id"))
                    val alfabet = mCursor.getString(mCursor.getColumnIndex("TextAlphabet"))
                    val image = mCursor.getString(mCursor.getColumnIndex("Alphabet"))

                    array.add(DrawModel(id, alfabet,image))
                } while (mCursor.moveToNext())
            }
            mCursor.close()
        }
        return array
    }



    @SuppressLint("Range")
    override fun getNumber(): ArrayList<NumbersModel> {
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
                    array.add(NumbersModel(id,
                        alfabet,
                        word,
                        image,
                        alfabetPlayer,
                        imagePlayer,
                        category))
                } while (mCursor.moveToNext())
            }
            mCursor.close()
        }
        return array
    }

    @SuppressLint("Range")
    override fun getToq(): ArrayList<NumbersModel> {
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
                    array.add(NumbersModel(id,
                        alfabet,
                        word,
                        image,
                        alfabetPlayer,
                        imagePlayer,
                        category))
                } while (mCursor.moveToNext())
            }
            mCursor.close()
        }
        return array
    }

    @SuppressLint("Range")
    override fun getJuft(): ArrayList<NumbersModel> {
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
                    array.add(NumbersModel(id,
                        alfabet,
                        word,
                        image,
                        alfabetPlayer,
                        imagePlayer,
                        category))
                } while (mCursor.moveToNext())
            }
            mCursor.close()
        }
        return array
    }

    @SuppressLint("Range")
    override fun getOrderAlphabet(): ArrayList<OrderModel> {
        val array: ArrayList<OrderModel> = ArrayList()
        val sql = "SELECT * from Order7"
        val mCursor = Query(sql)
        if (mCursor != null) {
            if (mCursor.moveToFirst()) {
                do {
                    val id = mCursor.getInt(mCursor.getColumnIndex("id"))
                    val alfabet = mCursor.getString(mCursor.getColumnIndex("Alphabet"))

                    array.add(OrderModel(id, alfabet))
                } while (mCursor.moveToNext())
            }
            mCursor.close()
        }
        return array

    }

    @SuppressLint("Range")
    override fun getAlphabetTest(): ArrayList<Question> {
        val array: ArrayList<Question> = ArrayList()
        val sql = "SELECT * from AlfabetsTest"
        val mCursor = Query(sql)
        if (mCursor != null) {
            if (mCursor.moveToFirst()) {
                do {
                    val id = mCursor.getInt(mCursor.getColumnIndex("id"))
                    val question = mCursor.getString(mCursor.getColumnIndex("question"))
                    val speechAlphabet = mCursor.getString(mCursor.getColumnIndex("speechAlphabet"))
                    val optionOne = mCursor.getString(mCursor.getColumnIndex("optionOne"))
                    val optionTwo = mCursor.getString(mCursor.getColumnIndex("optionTwo"))
                    val optionThree = mCursor.getString(mCursor.getColumnIndex("optionThree"))
                    val optionFour = mCursor.getString(mCursor.getColumnIndex("optionFour"))
                    val correctAnswer = mCursor.getInt(mCursor.getColumnIndex("correctAnswer"))

                  array.add(Question(id, question,speechAlphabet,optionOne,optionTwo,optionThree,optionFour,correctAnswer))
                } while (mCursor.moveToNext())
            }
            mCursor.close()
        }
        return array
    }


    @SuppressLint("Range")
    override fun getHarfyobiTest(): ArrayList<HarfyobiModel> {
        val array: ArrayList<HarfyobiModel> = ArrayList()
        val sql = "SELECT * from SearchAlphabet"
        val mCursor = Query(sql)
        if (mCursor != null) {
            if (mCursor.moveToFirst()) {
                do {
                    val id = mCursor.getInt(mCursor.getColumnIndex("id"))
                    val question = mCursor.getString(mCursor.getColumnIndex("question"))
                    val icon = mCursor.getString(mCursor.getColumnIndex("image"))
                    val speechAlphabet = mCursor.getString(mCursor.getColumnIndex("speechAlphabet"))
                    val optionOne = mCursor.getString(mCursor.getColumnIndex("optionOne"))
                    val optionTwo = mCursor.getString(mCursor.getColumnIndex("optionTwo"))
                    val optionThree = mCursor.getString(mCursor.getColumnIndex("optionThree"))
                    val optionFour = mCursor.getString(mCursor.getColumnIndex("optionFour"))
                    val correctAnswer = mCursor.getInt(mCursor.getColumnIndex("correctAnswer"))

                    array.add(HarfyobiModel(id, question,icon,speechAlphabet,optionOne,optionTwo,optionThree,optionFour,correctAnswer))
                } while (mCursor.moveToNext())
            }
            mCursor.close()
        }
        return array
    }




    companion object {
        val ALIFBO: String = "Alifbo"
        val RAQAMHO: String = "Raqamho"
        val RASMKASHI: String = "Rasmkashi"
        val TARTIB: String = "Tartib"
        val KALIMASOZI: String = "Kalimasozi"
        val KALIMAYOBI: String = "Kalimayobi"
    }
}