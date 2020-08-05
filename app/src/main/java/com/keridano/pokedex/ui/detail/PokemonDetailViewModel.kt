package com.keridano.pokedex.ui.detail

import android.util.Log
import com.keridano.pokedex.domain.GetPokemonDetailUseCase
import com.keridano.pokedex.utils.TAG
import com.ww.roxie.BaseViewModel
import com.ww.roxie.Reducer
import io.reactivex.rxkotlin.ofType
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers

class PokemonDetailViewModel(
    initialState: State?,
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase
) : BaseViewModel<Action, State>() {

    override val initialState = initialState ?: State(isIdle = true)

    private val reducer: Reducer<State, Change> = { state, change ->
        when (change) {
            is Change.Loading -> state.copy(
                isLoading = true,
                pokemon = null,
                isIdle = false,
                isLoadError = false
            )
            is Change.PokemonDetail -> state.copy(
                isLoading = false,
                pokemon = change.pokemon
            )
            is Change.PokemonLoadError -> state.copy(
                isLoading = false,
                isLoadError = true
            )
        }
    }

    init {
        bindActions()
    }

    private fun bindActions() {
        val loadPokemonDetailChange = actions.ofType<Action.LoadPokemonDetail>()
            .switchMap { action ->
                getPokemonDetailUseCase.findPokemonById(action.pokemonId)
                    .subscribeOn(Schedulers.io())
                    .toObservable()
                    .map<Change> { Change.PokemonDetail(it) }
                    .onErrorReturn { Change.PokemonLoadError(it) }
                    .startWith(Change.Loading)
            }

        disposables += loadPokemonDetailChange
            .scan(initialState, reducer)
            .filter { !it.isIdle }
            .distinctUntilChanged()
            .subscribe(state::postValue, this::handleError)
    }

    private fun handleError(throwable: Throwable){
        Log.e(TAG, "Throwable " + throwable.message)
    }

}
