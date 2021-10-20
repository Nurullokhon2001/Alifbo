package com.example.tajikenglish.MainMenu.ViewModel

import androidx.lifecycle.ViewModel
import com.example.tajikenglish.MainMenu.Model.MainItemData
import com.example.tajikenglish.MainMenu.Repository.MainRepository
import com.example.tajikenglish.R

class MainViewModel:ViewModel() {
    private val repository = MainRepository()

    fun getMenu():ArrayList<MainItemData>{
       return MainRepository().getMenu()
    }

}