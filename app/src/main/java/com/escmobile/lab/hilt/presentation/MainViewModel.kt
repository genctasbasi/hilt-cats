package com.escmobile.lab.hilt.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.escmobile.lab.hilt.data.CatRepository
import com.escmobile.lab.hilt.data.CatResponse
import com.escmobile.lab.hilt.utils.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainViewModel @Inject constructor(private val catRepository: CatRepository) : ViewModel() {

    private val _catResponse = SingleLiveEvent<CatResponse>()
    val catResponse: LiveData<CatResponse> = _catResponse

    fun getAnotherCat() {

        viewModelScope.launch(Dispatchers.IO) {
            val randomCat = catRepository.nextRandomCat()

            randomCat?.let {
                withContext(Dispatchers.Main) {
                    _catResponse.value = it
                }
            }
        }
    }
}