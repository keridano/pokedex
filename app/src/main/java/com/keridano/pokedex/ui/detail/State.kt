package com.keridano.pokedex.ui.detail

import com.keridano.pokedex.model.Pokemon
import com.ww.roxie.BaseState

data class State(
    val pokemon: Pokemon? = null,
    val isIdle: Boolean = false,
    val isLoading: Boolean = false,
    val isLoadError: Boolean = false
) : BaseState