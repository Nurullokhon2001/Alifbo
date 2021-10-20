package com.example.tajikenglish.repository

import com.example.tajikenglish.MainMenu.Model.MainItemData

interface MainRepository {
    fun getMenu(): ArrayList<MainItemData>

}