package com.isayevapps.amphibians.ui.screens.home

import com.isayevapps.amphibians.models.Amphibian

sealed class AmphibiansUiState {
    data class Success(val list: List<Amphibian>) : AmphibiansUiState()
    data class Error(val message: String) : AmphibiansUiState()
    object Loading : AmphibiansUiState()
}