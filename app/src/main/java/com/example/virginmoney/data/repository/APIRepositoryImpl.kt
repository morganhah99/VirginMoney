package com.example.virginmoney.data.repository

import com.example.virginmoney.data.api.APIEndpoints
import com.example.virginmoney.data.model.people.PeopleItemModel
import com.example.virginmoney.data.model.rooms.RoomsItemModel
import javax.inject.Inject

class APIRepositoryImpl @Inject constructor(
    private val apiDetails: APIEndpoints
): APIRepository {
    override suspend fun getPeople(): List<PeopleItemModel> = apiDetails.getPeople()

    override suspend fun getRooms(): List<RoomsItemModel> = apiDetails.getRooms()
}