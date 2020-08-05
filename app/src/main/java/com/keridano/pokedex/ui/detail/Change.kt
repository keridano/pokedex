package com.keridano.pokedex.ui.detail

import com.keridano.pokedex.model.Pokemon

sealed class Change {
    object Loading : Change()
    data class PokemonDetail(val pokemon: Pokemon) : Change()
    data class PokemonLoadError(val throwable: Throwable?) : Change()
}
