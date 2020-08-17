package com.escmobile.lab.hilt.data

import com.escmobile.lab.hilt.network.CatsApi
import javax.inject.Inject

/**
 * Well for the sake of the simplicity
 * we assume everything will go fine here hence no error handling!
 */
class CatRepository @Inject constructor(private val catsApi: CatsApi) {

    suspend fun nextRandomCat(): CatResponse? {
        val cats = catsApi.nextRandomCat()
        return if (cats.isNotEmpty()) cats[0] else null
    }
}