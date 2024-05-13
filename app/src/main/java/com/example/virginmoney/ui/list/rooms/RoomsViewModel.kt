package com.example.virginmoney.ui.list.rooms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virginmoney.data.model.rooms.RoomsItemModel
import com.example.virginmoney.data.repository.APIRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomsViewModel @Inject constructor(
    private val apiRepository: APIRepository
): ViewModel() {

    private val _roomList = MutableStateFlow<List<RoomsItemModel>>(emptyList())
    val roomList: StateFlow<List<RoomsItemModel>> = _roomList


    init {
        getRooms()
    }

    private fun getRooms() {
        viewModelScope.launch {

            val result = apiRepository.getRooms()

            if (result.isNotEmpty()) {
                _roomList.emit(result)
            }
        }
    }


}