package com.keridano.pokedex.data

class PokeApiClient(
    clientConfig: ClientConfig
) : PokeApi {

    private val service = PokeApiServiceImpl(clientConfig)

    // region ResourceList Lists

    // region Pokemon

    override fun getAbilityList(offset: Int, limit: Int) =
        service.getAbilityList(offset, limit)

    override fun getCharacteristicList(offset: Int, limit: Int) =
        service.getCharacteristicList(offset, limit)

    override fun getEggGroupList(offset: Int, limit: Int) =
        service.getEggGroupList(offset, limit)

    override fun getGenderList(offset: Int, limit: Int) =
        service.getGenderList(offset, limit)

    override fun getGrowthRateList(offset: Int, limit: Int) =
        service.getGrowthRateList(offset, limit)

    override fun getNatureList(offset: Int, limit: Int) =
        service.getNatureList(offset, limit)

    override fun getPokeathlonStatList(offset: Int, limit: Int) =
        service.getPokeathlonStatList(offset, limit)

    override fun getPokemonList(offset: Int, limit: Int) =
        service.getPokemonList(offset, limit)

    override fun getPokemonColorList(offset: Int, limit: Int) =
        service.getPokemonColorList(offset, limit)

    override fun getPokemonFormList(offset: Int, limit: Int) =
        service.getPokemonFormList(offset, limit)

    override fun getPokemonHabitatList(offset: Int, limit: Int) =
        service.getPokemonHabitatList(offset, limit)

    override fun getPokemonShapeList(offset: Int, limit: Int) =
        service.getPokemonShapeList(offset, limit)

    override fun getPokemonSpeciesList(offset: Int, limit: Int) =
        service.getPokemonSpeciesList(offset, limit)

    override fun getStatList(offset: Int, limit: Int) = service.getStatList(offset, limit)

    override fun getTypeList(offset: Int, limit: Int) = service.getTypeList(offset, limit)

    // endregion

    // endregion

    // region Pokemon

    override fun getAbility(id: Int) = service.getAbility(id)

    override fun getCharacteristic(id: Int) = service.getCharacteristic(id)

    override fun getEggGroup(id: Int) = service.getEggGroup(id)

    override fun getGender(id: Int) = service.getGender(id)

    override fun getGrowthRate(id: Int) = service.getGrowthRate(id)

    override fun getNature(id: Int) = service.getNature(id)

    override fun getPokeathlonStat(id: Int) = service.getPokeathlonStat(id)

    override fun getPokemon(id: Int) = service.getPokemon(id)

    override fun getPokemonEncounterList(id: Int) = service.getPokemonEncounterList(id)

    override fun getPokemonColor(id: Int) = service.getPokemonColor(id)

    override fun getPokemonForm(id: Int) = service.getPokemonForm(id)

    override fun getPokemonHabitat(id: Int) = service.getPokemonHabitat(id)

    override fun getPokemonShape(id: Int) = service.getPokemonShape(id)

    override fun getPokemonSpecies(id: Int) = service.getPokemonSpecies(id)

    override fun getStat(id: Int) = service.getStat(id)

    override fun getType(id: Int) = service.getType(id)

    // endregion Pokemon

}