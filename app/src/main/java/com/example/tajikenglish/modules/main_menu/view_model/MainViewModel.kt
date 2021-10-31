package com.example.tajikenglish.modules.main_menu.view_model

import com.example.tajikenglish.modules.drawsModel
import com.example.tajikenglish.core.di.BaseViewModel

class MainViewModel : BaseViewModel() {

    fun getMenu(): ArrayList<drawsModel> {
        return repository.getMenu()
    }
}