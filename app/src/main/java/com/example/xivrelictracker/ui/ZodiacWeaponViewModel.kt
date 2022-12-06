package com.example.xivrelictracker.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.xivrelictracker.api.XIVApiService
import com.example.xivrelictracker.data.QuestObject
import com.example.xivrelictracker.data.ZodiacWeaponRepository
import kotlinx.coroutines.launch

class ZodiacWeaponViewModel : ViewModel() {
    private val repository = ZodiacWeaponRepository(XIVApiService.create())

    private val _questList = MutableLiveData<QuestObject?>(null)
    val questList: LiveData<QuestObject?> = _questList

    private val _error = MutableLiveData<Throwable?>(null)
    val error: LiveData<Throwable?> = _error

    fun loadQuestList(qID: String?, lang: String?, apiKey: String) {
        viewModelScope.launch {
            val result = repository.loadQuestList(qID, lang, apiKey)
            _error.value = result.exceptionOrNull()
            _questList.value = result.getOrNull()
        }
    }
}