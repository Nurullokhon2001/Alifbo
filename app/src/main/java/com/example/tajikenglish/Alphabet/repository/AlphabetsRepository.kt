package com.example.tajikenglish.Alphabet.repository

import android.content.Context
import com.example.tajikenglish.Alphabet.repository.model.AlphabetsModel

class AlphabetsRepository(context: Context) {

    fun getAlphabet(): ArrayList<AlphabetsModel> {
        val array: ArrayList<AlphabetsModel> = ArrayList()
        array.add(AlphabetsModel(1, "А а","Анор", "anor.jpg","1.mp3","anor.mp3",1))
        array.add(AlphabetsModel(2, "Б б","Барг", "barg.png","2.mp3","barg.mp3",2))
        array.add(AlphabetsModel(3, "В в","Вагон", "vagon.png","3.mp3","vagon.mp3",2))
        array.add(AlphabetsModel(4, "Г г","Гул", "gul.png","4.mp3","gul.mp3",2))
        array.add(AlphabetsModel(5, "Ғ ғ","Ғалтак", "ghaltak.png","5.mp3","ghaltak.mp3",2))
//        array.add(AlphabetsModel(6, "Д д","Дутор", "dutor.jpg"))
//        array.add(AlphabetsModel(7, "Е е","Елим", "elim.png"))
//        array.add(AlphabetsModel(8, "Ё ё","Ёқут", "yoqut.png"))
//        array.add(AlphabetsModel(9, "Ж ж","Жола", "jola.jpg"))
//        array.add(AlphabetsModel(10, "З з","Занбур", "zanbur.png"))
//        array.add(AlphabetsModel(11, "И и","Искана", "iskana.jpg"))
//        array.add(AlphabetsModel(12, "ӣ","Моҳӣ", "mohi.png"))
//        array.add(AlphabetsModel(13, "Й й","Йод", "yod.jpg"))
//        array.add(AlphabetsModel(14, "К к","Кабутар", "kabutar.png"))
//        array.add(AlphabetsModel(15, "Қ қ","Қурбоққа", "qurboqqa.png"))
//        array.add(AlphabetsModel(16, "Л л","Лимӯ", "limu.png"))
//        array.add(AlphabetsModel(17, "М м","Мурғ", "murgh.png"))
//        array.add(AlphabetsModel(18, "Н н","Нон", "non.png"))
//        array.add(AlphabetsModel(19, "О о","Офтоб", "oftob.png"))
//        array.add(AlphabetsModel(20, "П п","Парасту", "parastu.png"))
//        array.add(AlphabetsModel(21, "Р р","Рӯбоҳ", "ruboh.png"))
//        array.add(AlphabetsModel(22, "С с","Ситора", "sitora.png"))
//        array.add(AlphabetsModel(23, "Т т","Табар", "tabar.png"))
//        array.add(AlphabetsModel(24, "У у","Уштур", "ushtur.png"))
//        array.add(AlphabetsModel(25, "Ӯ ӯ","Ӯрдак", "urdak.png"))
//        array.add(AlphabetsModel(26, "Ф ф","Фил", "fil.png"))
//        array.add(AlphabetsModel(27, "Х х","Хирс", "hirs.png"))
//        array.add(AlphabetsModel(28, "Ҳ ҳ","Ҳалқа", "halqa.png"))
//        array.add(AlphabetsModel(29, "Ч ч","Чуҷа", "chuja.png"))
//        array.add(AlphabetsModel(30, "Ҷ ҷ","Ҷайра", "jaira.png"))
//        array.add(AlphabetsModel(31, "Ш ш","Шамшер", "shamsher.png"))
//        array.add(AlphabetsModel(32, "ъ","шамъ", "sham.png"))
//        array.add(AlphabetsModel(33, "Э э","Элак", "elak.jpg"))
//        array.add(AlphabetsModel(34, "Ю ю","Юрмон", "yurmon.png"))
//        array.add(AlphabetsModel(35, "Я я","Яхдон", "yahmos.png"))
        return array
    }
}