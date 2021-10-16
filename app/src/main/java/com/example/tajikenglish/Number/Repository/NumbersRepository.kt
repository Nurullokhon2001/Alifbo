package com.example.tajikenglish.Number.Repository

import android.content.Context
import com.example.tajikenglish.Number.Model.NumbersModel

class NumbersRepository(context: Context) {

    fun getNumber(): ArrayList<NumbersModel> {
        val array: ArrayList<NumbersModel> = ArrayList()
        array.add(NumbersModel(0, "0", "Сифр", "rasmho/sifr.png", "1.mp3", "rasmho/anor.mp3", 1))
        array.add(NumbersModel(1, "1", "Як", "rasmho/yak.png", "1.mp3", "rasmho/anor.mp3", 1))
        array.add(NumbersModel(2, "2", "Ду", "rasmho/du.png", "2.mp3", "rasmho/barg.mp3", 2))
        array.add(NumbersModel(3, "3", "Се", "rasmho/se.png", "3.mp3", "rasmho/vagon.mp3", 1))
        array.add(NumbersModel(4, "4", "Чор", "rasmho/chor.png", "4.mp3", "rasmho/gul.mp3", 2))
        array.add(NumbersModel(5, "5", "Панч", "rasmho/panj.png", "5.mp3", "rasmho/ghaltak.mp3", 1))
        array.add(NumbersModel(6, "6","Шаш", "rasmho/shash.png","6.mp3","rasmho/dutor.mp3",2))
        array.add(NumbersModel(7, "7","Хафт", "rasmho/haft.png","7.mp3","rasmho/elim.mp3",1))
        array.add(NumbersModel(8, "8","Хашт", "rasmho/hasht.png","8.mp3","rasmho/yoqut.mp3",2))
        array.add(NumbersModel(9, "9","Нух", "rasmho/nuh.png","8.mp3","rasmho/yoqut.mp3",1))

        return array
    }
    fun getToq(): ArrayList<NumbersModel> {
        val array: ArrayList<NumbersModel> = ArrayList()
        array.add(NumbersModel(0, "1", "Як", "rasmho/yak.png", "1.mp3", "rasmho/anor.mp3", 1))
        array.add(NumbersModel(1, "3", "Се", "rasmho/se.png", "3.mp3", "rasmho/vagon.mp3", 1))
        array.add(NumbersModel(2, "5", "Панч", "rasmho/panj.png", "5.mp3", "rasmho/ghaltak.mp3", 1))
        array.add(NumbersModel(3, "7","Хафт", "rasmho/haft.png","7.mp3","rasmho/elim.mp3",1))
        array.add(NumbersModel(4, "9","Нух", "rasmho/nuh.png","8.mp3","rasmho/yoqut.mp3",1))
        return array
    }

    fun getJuft(): ArrayList<NumbersModel> {
        val array: ArrayList<NumbersModel> = ArrayList()
        array.add(NumbersModel(0, "2", "Ду", "rasmho/du.png", "2.mp3", "rasmho/barg.mp3", 2))
        array.add(NumbersModel(1, "4", "Чор", "rasmho/chor.png", "4.mp3", "rasmho/gul.mp3", 2))
        array.add(NumbersModel(2, "6","Шаш", "rasmho/shash.png","6.mp3","rasmho/dutor.mp3",2))
        array.add(NumbersModel(3, "8","Хашт", "rasmho/hasht.png","8.mp3","rasmho/yoqut.mp3",2))
        return array
    }


}