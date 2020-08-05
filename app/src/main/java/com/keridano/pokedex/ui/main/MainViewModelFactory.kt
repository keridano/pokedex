package com.keridano.pokedex.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.keridano.pokedex.domain.GetPokemonListUseCase

class MainViewModelFactory (
    private val initialState: State?,
    private val getPokemonListUseCase: GetPokemonListUseCase
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(initialState, getPokemonListUseCase) as T
    }
}