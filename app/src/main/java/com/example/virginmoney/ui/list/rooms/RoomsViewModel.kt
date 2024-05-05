package com.example.virginmoney.ui.list.rooms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virginmoney.data.api.RetrofitInstance
import com.example.virginmoney.data.model.rooms.RoomsItemModel
import com.example.virginmoney.databinding.FragmentRoomsBinding
import kotlinx.coroutines.launch

class RoomsViewModel: ViewModel() {

    private val _roomList = MutableLiveData<List<RoomsItemModel>>()
    val roomList: LiveData<List<RoomsItemModel>> = _roomList

    private val _text = MutableLiveData<String>()
    val text: LiveData<String> = _text

    init {
        getRooms()
    }

    fun getRooms() {
        viewModelScope.launch {

            val result = RetrofitInstance.apiClient.getRooms()

            if (result.isNotEmpty()) {
                _roomList.postValue(result)
                _text.postValue(result.toString())
            }
        }
    }


}