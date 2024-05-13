package com.example.virginmoney.data.repository

import com.example.virginmoney.data.model.people.PeopleItemModel
import com.example.virginmoney.data.model.rooms.RoomsItemModel

interface APIRepository {

    suspend fun getPeople(): List<PeopleItemModel>

    suspend fun getRooms(): List<RoomsItemModel>


}