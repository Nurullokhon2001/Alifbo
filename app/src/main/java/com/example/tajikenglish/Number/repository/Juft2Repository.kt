package com.encom.dynamicview.repository

import com.encom.dynamicview.repository.model.AlphabetButtonModel

class Juft2Repository {

    fun getAlphabet(): ArrayList<AlphabetButtonModel> {
        val array: ArrayList<AlphabetButtonModel> = ArrayList()


        array.add(AlphabetButtonModel(0, "0"))
        array.add(AlphabetButtonModel(1, "2"))
        array.add(AlphabetButtonModel(2, "4"))
        array.add(AlphabetButtonModel(3, "6"))
        array.add(AlphabetButtonModel(4, "8"))



        return array
    }
}