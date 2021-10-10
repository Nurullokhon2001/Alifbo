package com.example.tajikenglish.Alphabet.repository

import android.content.Context
import com.example.tajikenglish.Alphabet.repository.model.AlphabetsModel

class AlphabetsRepository(context: Context) {

    fun getAlphabet(): ArrayList<AlphabetsModel> {
        val array: ArrayList<AlphabetsModel> = ArrayList()
        array.add(AlphabetsModel(0, "А а", "Анор", "rasmho/anor.jpg", "1.mp3", "rasmho/anor.mp3", 1))
        array.add(AlphabetsModel(1, "Б б", "Барг", "rasmho/barg.png", "2.mp3", "rasmho/barg.mp3", 2))
        array.add(AlphabetsModel(2, "В в", "Вагон", "rasmho/vagon.png", "3.mp3", "rasmho/vagon.mp3", 2))
        array.add(AlphabetsModel(3, "Г г", "Гул", "rasmho/gul.png", "4.mp3", "rasmho/gul.mp3", 2))
        array.add(AlphabetsModel(4, "Ғ ғ", "Ғалтак", "rasmho/ghaltak.png", "5.mp3", "rasmho/ghaltak.mp3", 2))
        array.add(AlphabetsModel(5, "Д д","Дутор", "rasmho/dutor.jpg","6.mp3","rasmho/dutor.mp3",2))
        array.add(AlphabetsModel(6, "Е е","Елим", "rasmho/elim.png","7.mp3","rasmho/elim.mp3",3))
        array.add(AlphabetsModel(7, "Ё ё","Ёқут", "rasmho/yoqut.png","8.mp3","rasmho/yoqut.mp3",3))
        return array
    }
    fun getHamsado(): ArrayList<AlphabetsModel> {
        val array: ArrayList<AlphabetsModel> = ArrayList()
        array.add(AlphabetsModel(0, "Б б", "Барг", "rasmho/barg.png", "2.mp3", "rasmho/barg.mp3", 2))
        array.add(AlphabetsModel(1, "В в", "Вагон", "rasmho/vagon.png", "3.mp3", "rasmho/vagon.mp3", 2))
        array.add(AlphabetsModel(2, "Г г", "Гул", "rasmho/gul.png", "4.mp3", "rasmho/gul.mp3", 2))
        array.add(AlphabetsModel(3, "Ғ ғ", "Ғалтак", "rasmho/ghaltak.png", "5.mp3", "rasmho/ghaltak.mp3", 2))
        array.add(AlphabetsModel(4, "Д д","Дутор", "rasmho/dutor.jpg","6.mp3","rasmho/dutor.mp3",2))
        return array
    }

    fun getSadonok(): ArrayList<AlphabetsModel> {
        val array: ArrayList<AlphabetsModel> = ArrayList()
        array.add(AlphabetsModel(0, "А а", "Анор", "rasmho/anor.jpg", "1.mp3", "rasmho/anor.mp3", 1))
        return array
    }

    fun getYodbarsar(): ArrayList<AlphabetsModel> {
        val array: ArrayList<AlphabetsModel> = ArrayList()
        array.add(AlphabetsModel(0, "Е е","Елим", "rasmho/elim.png","7.mp3","rasmho/elim.mp3",3))
        array.add(AlphabetsModel(1, "Ё ё","Ёқут", "rasmho/yoqut.png","8.mp3","rasmho/yoqut.mp3",3))
        return array
    }

}