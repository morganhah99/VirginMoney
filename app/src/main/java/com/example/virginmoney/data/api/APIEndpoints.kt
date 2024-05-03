package com.example.virginmoney.data.api

import com.example.virginmoney.data.model.PeopleItemModel
import com.example.virginmoney.data.model.RoomsItemModel
import retrofit2.http.GET

interface APIEndpoints {

    @GET(APIDetail.PEOPLE_END_POINT)
    suspend fun getPeople(): List<PeopleItemModel>

    @GET(APIDetail.ROOMS_END_POINT)
    suspend fun getRooms(): List<RoomsItemModel>
}