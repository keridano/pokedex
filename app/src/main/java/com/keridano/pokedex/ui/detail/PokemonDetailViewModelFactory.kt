package com.keridano.pokedex.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.keridano.pokedex.domain.GetPokemonDetailUseCase

class PokemonDetailViewModelFactory(
    private val initialState: State?,
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PokemonDetailViewModel(initialState, getPokemonDetailUseCase) as T
    }
}