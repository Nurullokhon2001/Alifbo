package com.encom.dynamicview.repository

import com.encom.dynamicview.repository.model.AlphabetButtonModel

class SadonokMainCviewRepository {

    fun getAlphabet(): ArrayList<AlphabetButtonModel> {
        val array: ArrayList<AlphabetButtonModel> = ArrayList()


        array.add(AlphabetButtonModel(0, "Аа"))
        array.add(AlphabetButtonModel(1, "Ее"))
        array.add(AlphabetButtonModel(2, "Ёё"))
        array.add(AlphabetButtonModel(3, "Ии"))
        array.add(AlphabetButtonModel(4, "Ӣӣ"))
        array.add(AlphabetButtonModel(5, "Йй"))
        array.add(AlphabetButtonModel(6, "Оо"))
        array.add(AlphabetButtonModel(7, "Уу"))
        array.add(AlphabetButtonModel(8, "Ӯӯ"))
        array.add(AlphabetButtonModel(8, "Ээ"))
        array.add(AlphabetButtonModel(9, "Юю"))
        array.add(AlphabetButtonModel(10, "Яя"))



        return array
    }
}