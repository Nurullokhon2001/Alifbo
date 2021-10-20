package com.example.tajikenglish.MainMenu.ViewModel

import com.example.tajikenglish.MainMenu.Model.MainItemData
import com.example.tajikenglish.core.di.BaseViewModel

class MainViewModel : BaseViewModel() {

    fun getMenu(): ArrayList<MainItemData> {
        return repository.getMenu()
    }

}