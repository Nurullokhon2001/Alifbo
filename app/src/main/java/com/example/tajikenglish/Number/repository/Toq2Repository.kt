package com.encom.dynamicview.repository

import com.encom.dynamicview.repository.model.AlphabetButtonModel

class Toq2Repository {

    fun getAlphabet(): ArrayList<AlphabetButtonModel> {
        val array: ArrayList<AlphabetButtonModel> = ArrayList()

        array.add(AlphabetButtonModel(0, "0"))
        array.add(AlphabetButtonModel(1, "1"))
        array.add(AlphabetButtonModel(2, "3"))
        array.add(AlphabetButtonModel(3, "5"))
        array.add(AlphabetButtonModel(4, "7"))
        array.add(AlphabetButtonModel(5, "9"))



        return array
    }
}