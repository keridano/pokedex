package com.keridano.pokedex.ui.main

import com.keridano.pokedex.model.NamedApiResourceList
import com.ww.roxie.BaseState

data class State (
    val pokemon: NamedApiResourceList =
        NamedApiResourceList(-1, null, null, emptyList()),
    val isIdle: Boolean = false,
    val isLoading: Boolean = false,
    val isError: Boolean = false
) : BaseState