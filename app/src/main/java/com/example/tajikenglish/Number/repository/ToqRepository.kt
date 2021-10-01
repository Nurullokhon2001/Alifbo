package com.example.tajikenglish.Number.repository

import com.encom.dynamicview.repository.model.AlphabetImageWordModel

class ToqRepository {

    fun getAlphabet(): ArrayList<AlphabetImageWordModel> {
        val array: ArrayList<AlphabetImageWordModel> = ArrayList()
        array.add(AlphabetImageWordModel(1, "0","СИФР", "sifr.png"))
        array.add(AlphabetImageWordModel(2, "1","ЯК", "yak.png"))
        array.add(AlphabetImageWordModel(3, "3","СЕ","se.png"))
        array.add(AlphabetImageWordModel(4, "5","ПАНҶ","panj.png"))
        array.add(AlphabetImageWordModel(5, "7","ҲАФТ", "haft.png"))
        array.add(AlphabetImageWordModel(6, "9","НУҲ", "nuh.png"))

        return array
    }
}
