package com.example.tajikenglish.Alphabet.repository

import com.encom.dynamicview.repository.model.AlphabetImageWordModel

class AlphabetRepository {

    fun getAlphabet(): ArrayList<AlphabetImageWordModel> {
        val array: ArrayList<AlphabetImageWordModel> = ArrayList()
        array.add(AlphabetImageWordModel(1, "Аа","Анор", "anor.jpg"))
        array.add(AlphabetImageWordModel(2, "Бб","Барг", "barg.png"))
        array.add(AlphabetImageWordModel(3, "Вв","Вагон","vagon.png"))
        array.add(AlphabetImageWordModel(4, "Гг","гул", "gul.png"))
        array.add(AlphabetImageWordModel(5, "Ғғ","Ғалтак", "ghaltak.png"))
        array.add(AlphabetImageWordModel(6, "Дд","Дутор", "dutor.jpg"))
        array.add(AlphabetImageWordModel(7, "Ее","Елим", "elim.png"))
        array.add(AlphabetImageWordModel(8, "Ёё","Ёқут", "yoqut.png"))
        array.add(AlphabetImageWordModel(9, "Жж","Жола", "jola.jpg"))
        array.add(AlphabetImageWordModel(10, "Зз","Занбур", "zanbur.png"))
        array.add(AlphabetImageWordModel(11, "Ии","Искана", "iskana.jpg"))
        array.add(AlphabetImageWordModel(12, "ӣ","Моҳӣ", "mohi.png"))
        array.add(AlphabetImageWordModel(13, "Йй","Йод", "yod.jpg"))
        array.add(AlphabetImageWordModel(14, "Кк","Кабутар", "kabutar.png"))
        array.add(AlphabetImageWordModel(15, "Ққ","Қурбоққа", "qurboqqa.png"))
        array.add(AlphabetImageWordModel(16, "Лл","Лимӯ", "limu.png"))
        array.add(AlphabetImageWordModel(17, "Мм","Мурғ", "murgh.png"))
        array.add(AlphabetImageWordModel(18, "Нн","Нон", "non.png"))
        array.add(AlphabetImageWordModel(19, "Оо","Офтоб", "oftob.png"))
        array.add(AlphabetImageWordModel(20, "Пп","Парасту", "parastu.png"))
        array.add(AlphabetImageWordModel(21, "Рр","Рӯбоҳ", "ruboh.png"))
        array.add(AlphabetImageWordModel(22, "Сс","Ситора", "sitora.png"))
        array.add(AlphabetImageWordModel(23, "Тт","Табар", "tabar.png"))
        array.add(AlphabetImageWordModel(24, "Уу","Уштур", "ushtur.png"))
        array.add(AlphabetImageWordModel(25, "Ӯӯ","Ӯрдак", "urdak.png"))
        array.add(AlphabetImageWordModel(26, "Фф","Фил", "fil.png"))
        array.add(AlphabetImageWordModel(27, "Хх","Хирс", "hirs.png"))
        array.add(AlphabetImageWordModel(28, "Ҳҳ","Ҳалқа", "halqa.png"))
        array.add(AlphabetImageWordModel(29, "Чч","Чуҷа", "chuja.png"))
        array.add(AlphabetImageWordModel(30, "Ҷҷ","Ҷайра", "jaira.png"))
        array.add(AlphabetImageWordModel(31, "Шш","Шамшер", "shamsher.png"))
        array.add(AlphabetImageWordModel(32, "ъ","шамъ", "sham.png"))
        array.add(AlphabetImageWordModel(33, "Ээ","Элак", "elak.jpg"))
        array.add(AlphabetImageWordModel(34, "Юю","Юрмон", "yurmon.png"))
        array.add(AlphabetImageWordModel(35, "Яя","Яхдон", "yahmos.png"))
        return array
    }
}
