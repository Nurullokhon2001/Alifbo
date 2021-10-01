package com.example.tajikenglish.Alphabet.repository

import com.encom.dynamicview.repository.model.AlphabetImageWordModel

class SadonokRepository {

    fun getAlphabet(): ArrayList<AlphabetImageWordModel> {
        val array: ArrayList<AlphabetImageWordModel> = ArrayList()

        array.add(AlphabetImageWordModel(1, "Аа","Анор", "anor.jpg"))
        array.add(AlphabetImageWordModel(2, "Ее","Елим", "elim.png"))
        array.add(AlphabetImageWordModel(3, "Ёё","Ёқут", "yoqut.png"))
        array.add(AlphabetImageWordModel(4, "Ии","Искана", "iskana.jpg"))
        array.add(AlphabetImageWordModel(5, "Йй","Йод", "yod.jpg"))
        array.add(AlphabetImageWordModel(6, "Оо","Офтоб", "oftob.png"))
        array.add(AlphabetImageWordModel(7, "Уу","Уштур", "ushtur.png"))
        array.add(AlphabetImageWordModel(8, "Ӯӯ","Ӯрдак", "urdak.png"))
        array.add(AlphabetImageWordModel(9, "Ээ","Элак", "elak.jpg"))
        array.add(AlphabetImageWordModel(10, "Юю","Юрмон", "yurmon.png"))
        array.add(AlphabetImageWordModel(11, "Яя","Яхдон", "yahmos.png"))






        return array
    }
}
