package com.keridano.pokedex.ui.main

import com.ww.roxie.BaseAction

sealed class Action : BaseAction {
    object LoadPokemonData : Action()
}