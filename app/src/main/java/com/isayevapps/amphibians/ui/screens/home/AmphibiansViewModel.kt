package com.isayevapps.amphibians.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.isayevapps.amphibians.AmphibiansApplication
import com.isayevapps.amphibians.data.AmphibiansRepository
import kotlinx.coroutines.launch

class AmphibiansViewModel(
    private val repository: AmphibiansRepository
) : ViewModel() {

    var amphibiansUiState by mutableStateOf<AmphibiansUiState>(AmphibiansUiState.Loading)
        private set

    init {
        getAmphibians()
    }

    fun getAmphibians() {
        viewModelScope.launch {
            amphibiansUiState = AmphibiansUiState.Loading
            amphibiansUiState = try {
                val listResult = repository.getAmphibians()
                AmphibiansUiState.Success(listResult)
            } catch (e: Exception) {
                AmphibiansUiState.Error(e.message.toString())
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibiansApplication)
                val amphibiansRepository = application.container.amphibiansRepository
                AmphibiansViewModel(repository = amphibiansRepository)
            }
        }
    }
}