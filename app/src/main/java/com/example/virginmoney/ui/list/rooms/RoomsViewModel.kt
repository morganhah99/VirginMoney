package com.example.virginmoney.ui.list.rooms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virginmoney.data.model.rooms.RoomsItemModel
import com.example.virginmoney.data.repository.APIRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomsViewModel @Inject constructor(
    private val apiRepository: APIRepository
): ViewModel() {

    private val _roomList = MutableLiveData<List<RoomsItemModel>>()
    val roomList: LiveData<List<RoomsItemModel>> = _roomList

    private val _text = MutableLiveData<String>()

    init {
        getRooms()
    }

    private fun getRooms() {
        viewModelScope.launch {

            val result = apiRepository.getRooms()

            if (result.isNotEmpty()) {
                _roomList.postValue(result)
                _text.postValue(result.toString())
            }
        }
    }


}