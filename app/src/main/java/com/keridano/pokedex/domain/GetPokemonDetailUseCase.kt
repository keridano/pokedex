package com.keridano.pokedex.domain

import com.keridano.pokedex.data.PokeApiClient
import com.keridano.pokedex.model.Pokemon
import io.reactivex.Single

class GetPokemonDetailUseCase(
    private val pokeApiClient: PokeApiClient
) {
    fun findPokemonById(pokemonId: Int): Single<Pokemon> = Single.fromObservable(pokeApiClient.getPokemon(pokemonId))
}