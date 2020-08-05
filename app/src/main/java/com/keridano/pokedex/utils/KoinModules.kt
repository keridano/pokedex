package com.keridano.pokedex.utils

import com.keridano.pokedex.data.ClientConfig
import com.keridano.pokedex.data.PokeApiClient
import com.keridano.pokedex.domain.GetPokemonDetailUseCase
import com.keridano.pokedex.domain.GetPokemonListUseCase
import com.keridano.pokedex.ui.detail.PokemonDetailViewModel
import com.keridano.pokedex.ui.detail.PokemonStatsAdapter
import com.keridano.pokedex.ui.detail.PokemonTypesAdapter
import com.keridano.pokedex.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    single { ClientConfig() }
    single { PokeApiClient(get()) }
    single { GetPokemonListUseCase(get()) }
    single { GetPokemonDetailUseCase(get()) }
}

val uiModule = module {
    factory { PokemonStatsAdapter() }
    factory { PokemonTypesAdapter() }
    viewModel { PokemonDetailViewModel(null, get()) }
    viewModel { MainViewModel(null, get()) }
}
