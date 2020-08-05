package com.keridano.pokedex.data

import com.keridano.pokedex.model.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import io.reactivex.Observable

interface PokeApiService {

    // region Pokemon list queries

    @GET("ability/")
    fun getAbilityList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("characteristic/")
    fun getCharacteristicList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<ApiResourceList>

    @GET("egg-group/")
    fun getEggGroupList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("gender/")
    fun getGenderList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("growth-rate/")
    fun getGrowthRateList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("nature/")
    fun getNatureList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("pokeathlon-stat/")
    fun getPokeathlonStatList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("pokemon/")
    fun getPokemonList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("pokemon-color/")
    fun getPokemonColorList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("pokemon-form/")
    fun getPokemonFormList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("pokemon-habitat/")
    fun getPokemonHabitatList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("pokemon-shape/")
    fun getPokemonShapeList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("pokemon-species/")
    fun getPokemonSpeciesList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("stat/")
    fun getStatList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    @GET("type/")
    fun getTypeList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Observable<NamedApiResourceList>

    //endregion

    // region Pokemon single queries

    @GET("ability/{id}/")
    fun getAbility(@Path("id") id: Int): Observable<Ability>

    @GET("characteristic/{id}/")
    fun getCharacteristic(@Path("id") id: Int): Observable<Characteristic>

    @GET("egg-group/{id}/")
    fun getEggGroup(@Path("id") id: Int): Observable<EggGroup>

    @GET("gender/{id}/")
    fun getGender(@Path("id") id: Int): Observable<Gender>

    @GET("growth-rate/{id}/")
    fun getGrowthRate(@Path("id") id: Int): Observable<GrowthRate>

    @GET("nature/{id}/")
    fun getNature(@Path("id") id: Int): Observable<Nature>

    @GET("pokeathlon-stat/{id}/")
    fun getPokeathlonStat(@Path("id") id: Int): Observable<PokeathlonStat>

    @GET("pokemon/{id}/")
    fun getPokemon(@Path("id") id: Int): Observable<Pokemon>

    @GET("pokemon/{id}/encounters/")
    fun getPokemonEncounterList(@Path("id") id: Int): Observable<List<LocationAreaEncounter>>

    @GET("pokemon-color/{id}/")
    fun getPokemonColor(@Path("id") id: Int): Observable<PokemonColor>

    @GET("pokemon-form/{id}/")
    fun getPokemonForm(@Path("id") id: Int): Observable<PokemonForm>

    @GET("pokemon-habitat/{id}/")
    fun getPokemonHabitat(@Path("id") id: Int): Observable<PokemonHabitat>

    @GET("pokemon-shape/{id}/")
    fun getPokemonShape(@Path("id") id: Int): Observable<PokemonShape>

    @GET("pokemon-species/{id}/")
    fun getPokemonSpecies(@Path("id") id: Int): Observable<PokemonSpecies>

    @GET("stat/{id}/")
    fun getStat(@Path("id") id: Int): Observable<Stat>

    @GET("type/{id}/")
    fun getType(@Path("id") id: Int): Observable<Type>

    //endregion
}