package com.encom.dynamicview.repository

import com.encom.dynamicview.repository.model.AlphabetButtonModel

class AlphabetMainCviewRepository {

    fun getAlphabet(): ArrayList<AlphabetButtonModel> {
        val array: ArrayList<AlphabetButtonModel> = ArrayList()


        array.add(AlphabetButtonModel(0, "Аа"))
        array.add(AlphabetButtonModel(1, "Бб"))
        array.add(AlphabetButtonModel(2, "Вв"))
        array.add(AlphabetButtonModel(3, "Гг"))
        array.add(AlphabetButtonModel(4, "Ғғ"))
        array.add(AlphabetButtonModel(5, "Дд"))
        array.add(AlphabetButtonModel(6, "Ее"))
        array.add(AlphabetButtonModel(7, "Ёё"))
        array.add(AlphabetButtonModel(8, "Жж"))
        array.add(AlphabetButtonModel(9, "Зз"))
        array.add(AlphabetButtonModel(10, "Ии"))
        array.add(AlphabetButtonModel(11, "Ӣӣ"))
        array.add(AlphabetButtonModel(12, "Йй"))
        array.add(AlphabetButtonModel(13, "Кк"))
        array.add(AlphabetButtonModel(14, "Ққ"))
        array.add(AlphabetButtonModel(15, "Лл"))
        array.add(AlphabetButtonModel(16, "Мм"))
        array.add(AlphabetButtonModel(17, "Нн"))
        array.add(AlphabetButtonModel(18, "Оо"))
        array.add(AlphabetButtonModel(19, "Пп"))
        array.add(AlphabetButtonModel(20, "Рр"))
        array.add(AlphabetButtonModel(21, "Сс"))
        array.add(AlphabetButtonModel(22, "Тт"))
        array.add(AlphabetButtonModel(23, "Уу"))
        array.add(AlphabetButtonModel(24, "Ӯӯ"))
        array.add(AlphabetButtonModel(25, "Хх"))
        array.add(AlphabetButtonModel(26, "Ҳҳ"))
        array.add(AlphabetButtonModel(27, "Фф"))
        array.add(AlphabetButtonModel(28, "Чч"))
        array.add(AlphabetButtonModel(29, "Ҷҷ"))
        array.add(AlphabetButtonModel(30, "Шш"))
        array.add(AlphabetButtonModel(31, "Ъ"))
        array.add(AlphabetButtonModel(32, "Ээ"))
        array.add(AlphabetButtonModel(33, "Юю"))
        array.add(AlphabetButtonModel(34, "Яя"))


        return array
    }
}