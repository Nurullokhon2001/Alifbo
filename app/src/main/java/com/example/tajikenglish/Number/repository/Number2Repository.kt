package com.encom.dynamicview.repository

import com.encom.dynamicview.repository.model.AlphabetButtonModel

class Number2Repository {

    fun getAlphabet(): ArrayList<AlphabetButtonModel> {
        val array: ArrayList<AlphabetButtonModel> = ArrayList()


        array.add(AlphabetButtonModel(0, "0"))
        array.add(AlphabetButtonModel(1, "1"))
        array.add(AlphabetButtonModel(2, "2"))
        array.add(AlphabetButtonModel(3, "3"))
        array.add(AlphabetButtonModel(4, "4"))
        array.add(AlphabetButtonModel(5, "5"))
        array.add(AlphabetButtonModel(6, "6"))
        array.add(AlphabetButtonModel(7, "7"))
        array.add(AlphabetButtonModel(8, "8"))
        array.add(AlphabetButtonModel(9, "9"))


        return array
    }
}