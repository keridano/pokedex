package com.keridano.pokedex.ui.main
import com.keridano.pokedex.model.NamedApiResourceList

sealed class Change {
    object Loading : Change()
    data class Pokemon(val pokemon: NamedApiResourceList) : Change()
    data class Error(val throwable: Throwable?) : Change()
}