package com.example.tajikenglish.Alphabet.repository

import com.encom.dynamicview.repository.model.AlphabetImageWordModel

class HamsadoRepository {

    fun getAlphabet(): ArrayList<AlphabetImageWordModel> {
        val array: ArrayList<AlphabetImageWordModel> = ArrayList()
        array.add(AlphabetImageWordModel(1, "Бб","Барг", "barg.png"))
        array.add(AlphabetImageWordModel(2, "Вв","Вагон","vagon.png"))
        array.add(AlphabetImageWordModel(3, "Гг","гул", "gul.png"))
        array.add(AlphabetImageWordModel(4, "Ғғ","Ғалтак", "ghaltak.png"))
        array.add(AlphabetImageWordModel(5, "Дд","Дутор", "dutor.jpg"))
        array.add(AlphabetImageWordModel(6, "Жж","Жола", "jola.jpg"))
        array.add(AlphabetImageWordModel(7, "Зз","Занбур", "zanbur.png"))
        array.add(AlphabetImageWordModel(8, "Кк","Кабутар", "kabutar.png"))
        array.add(AlphabetImageWordModel(9, "Ққ","Қурбоққа", "qurboqqa.png"))
        array.add(AlphabetImageWordModel(10, "Лл","Лимӯ", "limu.png"))
        array.add(AlphabetImageWordModel(11, "Мм","Мурғ", "murgh.png"))
        array.add(AlphabetImageWordModel(12, "Нн","Нон", "non.png"))
        array.add(AlphabetImageWordModel(13, "Пп","Парасту", "parastu.png"))
        array.add(AlphabetImageWordModel(14, "Рр","Рӯбоҳ", "ruboh.png"))
        array.add(AlphabetImageWordModel(15, "Сс","Ситора", "sitora.png"))
        array.add(AlphabetImageWordModel(16, "Тт","Табар", "tabar.png"))
        array.add(AlphabetImageWordModel(17, "Фф","Фил", "fil.png"))
        array.add(AlphabetImageWordModel(18, "Хх","Хирс", "hirs.png"))
        array.add(AlphabetImageWordModel(19, "Ҳҳ","Ҳалқа", "halqa.png"))
        array.add(AlphabetImageWordModel(20, "Чч","Чуҷа", "chuja.png"))
        array.add(AlphabetImageWordModel(21, "Ҷҷ","Ҷайра", "jaira.png"))
        array.add(AlphabetImageWordModel(22, "Шш","Шамшер", "shamsher.png"))

        return array
    }
}
