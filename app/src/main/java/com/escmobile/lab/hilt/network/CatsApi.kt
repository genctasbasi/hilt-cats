package com.escmobile.lab.hilt.network

import com.escmobile.lab.hilt.data.CatResponse
import retrofit2.http.GET

const val CATS_BASE_URL = "https://api.thecatapi.com/v1/images/"
const val SEARCH_CATS_END_POINT = "search"

interface CatsApi {

    @GET(SEARCH_CATS_END_POINT)
    suspend fun nextRandomCat(): List<CatResponse>
}