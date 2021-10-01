package com.encom.dynamicview.repository

import com.encom.dynamicview.repository.model.AlphabetButtonModel

class HamsadoMainCviewRepository {

    fun getAlphabet(): ArrayList<AlphabetButtonModel> {
        val array: ArrayList<AlphabetButtonModel> = ArrayList()


        array.add(AlphabetButtonModel(0, "Бб"))
        array.add(AlphabetButtonModel(1, "Вв"))
        array.add(AlphabetButtonModel(2, "Гг"))
        array.add(AlphabetButtonModel(3, "Ғғ"))
        array.add(AlphabetButtonModel(4, "Дд"))
        array.add(AlphabetButtonModel(5, "Жж"))
        array.add(AlphabetButtonModel(6, "Зз"))
        array.add(AlphabetButtonModel(7, "Кк"))
        array.add(AlphabetButtonModel(8, "Ққ"))
        array.add(AlphabetButtonModel(9, "Лл"))
        array.add(AlphabetButtonModel(10, "Мм"))
        array.add(AlphabetButtonModel(11, "Нн"))
        array.add(AlphabetButtonModel(12, "Пп"))
        array.add(AlphabetButtonModel(13, "Рр"))
        array.add(AlphabetButtonModel(14, "Сс"))
        array.add(AlphabetButtonModel(15, "Тт"))
        array.add(AlphabetButtonModel(16, "Хх"))
        array.add(AlphabetButtonModel(17, "Ҳҳ"))
        array.add(AlphabetButtonModel(18, "Фф"))
        array.add(AlphabetButtonModel(19, "Чч"))
        array.add(AlphabetButtonModel(20, "Ҷҷ"))
        array.add(AlphabetButtonModel(21, "Шш"))



        return array
    }
}