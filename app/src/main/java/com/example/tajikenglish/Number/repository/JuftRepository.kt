package com.example.tajikenglish.Number.repository

import com.encom.dynamicview.repository.model.AlphabetImageWordModel

class JuftRepository {

    fun getAlphabet(): ArrayList<AlphabetImageWordModel> {
        val array: ArrayList<AlphabetImageWordModel> = ArrayList()

        array.add(AlphabetImageWordModel(1, "0","СИФР", "sifr.png"))
        array.add(AlphabetImageWordModel(2, "2","ДУ","du.png"))
        array.add(AlphabetImageWordModel(3, "4","ЧОР", "chor.png"))
        array.add(AlphabetImageWordModel(4, "6","ШАШ", "shash.png"))
        array.add(AlphabetImageWordModel(5, "8","ҲАШТ", "hasht.png"))






        return array
    }
}
