package com.keridano.pokedex.ui.detail

import com.ww.roxie.BaseAction

sealed class Action : BaseAction {
    data class LoadPokemonDetail(val pokemonId: Int) : Action() {
        override fun toString() = obfuscatedString()
    }
}