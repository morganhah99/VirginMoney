package com.example.virginmoney.ui.list.people

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.virginmoney.data.model.people.PeopleItemModel
import com.example.virginmoney.data.repository.APIRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val apiRepository: APIRepository
): ViewModel() {

    private val _peopleList = MutableLiveData<List<PeopleItemModel>>()
    val peopleList: LiveData<List<PeopleItemModel>> = _peopleList

    init {
        getPeople()
    }

    private fun getPeople() {
        viewModelScope.launch {
            val result = apiRepository.getPeople()

            if (result.isNotEmpty()) {
                _peopleList.postValue(result)
            }
        }
    }
}