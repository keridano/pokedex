package com.keridano.pokedex.domain

import com.keridano.pokedex.data.PokeApiClient
import com.keridano.pokedex.model.NamedApiResourceList
import io.reactivex.Single

class GetPokemonListUseCase(
    private val pokeApiClient: PokeApiClient
) {
    fun getPokemonList(): Single<NamedApiResourceList> = Single.fromObservable(pokeApiClient.getPokemonList(0, 100))
}