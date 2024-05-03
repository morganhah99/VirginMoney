package com.example.virginmoney.ui.list.people

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.virginmoney.data.api.RetrofitInstance
import com.example.virginmoney.data.model.PeopleItemModel
import kotlinx.coroutines.launch


class PeopleViewModel: ViewModel() {

    private val _peopleList = MutableLiveData<List<PeopleItemModel>>()
    val peopleList: LiveData<List<PeopleItemModel>> = _peopleList

    init {
        getPeople()
    }

    fun getPeople() {
        viewModelScope.launch {
            val result = RetrofitInstance.apiClient.getPeople()

            if (!result.isNullOrEmpty()) {
                _peopleList.postValue(result)
            }
        }
    }
}