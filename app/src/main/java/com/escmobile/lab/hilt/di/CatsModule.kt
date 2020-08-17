package com.escmobile.lab.hilt.di

import com.escmobile.lab.hilt.data.CatRepository
import com.escmobile.lab.hilt.network.CATS_BASE_URL
import com.escmobile.lab.hilt.network.CatsApi
import com.escmobile.lab.hilt.presentation.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ActivityComponent::class)
object CatsModule {

    @Provides
    fun provideCatsApi(): CatsApi {

        val builder = Retrofit.Builder()
            .baseUrl(CATS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return builder.create(CatsApi::class.java)
    }

    @Provides
    fun provideCatRepository(catsApi: CatsApi): CatRepository = CatRepository(catsApi)

    @Provides
    fun provideMainViewModel(catRepository: CatRepository): MainViewModel =
        MainViewModel(catRepository)
}