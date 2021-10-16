package com.example.tajikenglish.mainFragment.model

import com.example.tajikenglish.R
class MainRepository() {
    fun getMenu():ArrayList<MainItemData>{
        val arrayList:ArrayList<MainItemData> = ArrayList()
        arrayList.add(MainItemData(ALIFBO, R.drawable.abc,"Алифбо",R.color.alifbo))
        arrayList.add(MainItemData(RAQAMHO, R.drawable.numbers,"Рақамхо",R.color.raqam))
        arrayList.add(MainItemData(RASMKASHI, R.drawable.words,"Расмкаши",R.color.rasmkashi))
        arrayList.add(MainItemData(TARTIB, R.drawable.phrases,"Тартиб",R.color.tartib))
        arrayList.add(MainItemData(KALIMASOZI, R.drawable.topic,"Калимасозӣ",R.color.kalimasozi))
        arrayList.add(MainItemData(KALIMAYOBI, R.drawable.verbs,"Калимаёбӣ",R.color.kalimayobi))
        return  arrayList
    }
    companion object{
        val ALIFBO: String = "Alifbo"
        val RAQAMHO:String = "Raqamho"
        val RASMKASHI: String = "Rasmkashi"
        val TARTIB: String = "Tartib"
        val KALIMASOZI:String = "Kalimasozi"
        val KALIMAYOBI: String = "Kalimayobi"
    }
}