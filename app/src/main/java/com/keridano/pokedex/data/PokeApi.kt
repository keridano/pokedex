package com.keridano.pokedex.data

import com.keridano.pokedex.model.*
import io.reactivex.Observable

interface PokeApi {

    fun getAbilityList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getCharacteristicList(offset: Int, limit: Int): Observable<ApiResourceList>

    fun getEggGroupList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getGenderList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getGrowthRateList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getNatureList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getPokeathlonStatList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getPokemonList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getPokemonColorList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getPokemonFormList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getPokemonHabitatList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getPokemonShapeList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getPokemonSpeciesList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getStatList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getTypeList(offset: Int, limit: Int): Observable<NamedApiResourceList>

    fun getAbility(id: Int): Observable<Ability>

    fun getCharacteristic(id: Int): Observable<Characteristic>

    fun getEggGroup(id: Int): Observable<EggGroup>

    fun getGender(id: Int): Observable<Gender>

    fun getGrowthRate(id: Int): Observable<GrowthRate>

    fun getNature(id: Int): Observable<Nature>

    fun getPokeathlonStat(id: Int): Observable<PokeathlonStat>

    fun getPokemon(id: Int): Observable<Pokemon>

    fun getPokemonEncounterList(id: Int): Observable<List<LocationAreaEncounter>>

    fun getPokemonColor(id: Int): Observable<PokemonColor>

    fun getPokemonForm(id: Int): Observable<PokemonForm>

    fun getPokemonHabitat(id: Int): Observable<PokemonHabitat>

    fun getPokemonShape(id: Int): Observable<PokemonShape>

    fun getPokemonSpecies(id: Int): Observable<PokemonSpecies>

    fun getStat(id: Int): Observable<Stat>

    fun getType(id: Int): Observable<Type>
}