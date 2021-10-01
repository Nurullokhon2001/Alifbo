package com.example.tajikenglish.Number.repository

import com.encom.dynamicview.repository.model.AlphabetImageWordModel

class NumberRepository {

    fun getAlphabet(): ArrayList<AlphabetImageWordModel> {
        val array: ArrayList<AlphabetImageWordModel> = ArrayList()
        array.add(AlphabetImageWordModel(1, "0","СИФР", "sifr.png"))
        array.add(AlphabetImageWordModel(2, "1","ЯК", "yak.png"))
        array.add(AlphabetImageWordModel(3, "2","ДУ","du.png"))
        array.add(AlphabetImageWordModel(4, "3","СЕ","se.png"))
        array.add(AlphabetImageWordModel(5, "4","ЧОР", "chor.png"))
        array.add(AlphabetImageWordModel(6, "5","ПАНҶ","panj.png"))
        array.add(AlphabetImageWordModel(7, "6","ШАШ", "shash.png"))
        array.add(AlphabetImageWordModel(8, "7","ҲАФТ", "hasht.png"))
        array.add(AlphabetImageWordModel(9, "8","ҲАШТ", "hasht.png"))
        array.add(AlphabetImageWordModel(10, "9","НУҲ", "nuh.png"))
        return array
    }
}
