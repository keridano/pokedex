package com.keridano.pokedex.ui.main

import android.util.Log
import com.keridano.pokedex.domain.GetPokemonListUseCase
import com.keridano.pokedex.model.NamedApiResourceList
import com.keridano.pokedex.utils.TAG
import com.ww.roxie.BaseViewModel
import com.ww.roxie.Reducer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.ofType
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers

class MainViewModel(
    initialState: State?,
    private val getPokemonListUseCase: GetPokemonListUseCase
) : BaseViewModel<Action, State>() {

    override val initialState = initialState ?: State(isIdle = true)

    private val reducer: Reducer<State, Change> = { state, change ->
        when (change) {
            is Change.Loading -> state.copy(
                isIdle = false,
                isLoading = true,
                pokemon = NamedApiResourceList(-1, null, null, emptyList()),
                isError = false
            )
            is Change.Pokemon -> state.copy(
                isLoading = false,
                pokemon = change.pokemon
            )
            is Change.Error -> state.copy(
                isLoading = false,
                isError = true
            )
        }
    }

    init {
        bindActions()
    }

    private fun bindActions() {
        val loadPokemonChange = actions.ofType<Action.LoadPokemonData>()
            .switchMap {
                getPokemonListUseCase.getPokemonList()
                    .subscribeOn(Schedulers.io())
                    .toObservable()
                    .observeOn(AndroidSchedulers.mainThread())
                    .map<Change> { Change.Pokemon(it) }
                    .defaultIfEmpty(Change.Pokemon(
                        NamedApiResourceList(-1, null, null, emptyList())))
                    .onErrorReturn { Change.Error(it) }
                    .startWith(Change.Loading)
            }

        disposables += loadPokemonChange
            .scan(initialState, reducer)
            .filter { !it.isIdle }
            .distinctUntilChanged()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(state::setValue, this::handleError)
    }

    private fun handleError(throwable: Throwable){
        Log.e(TAG, "Throwable " + throwable.message)
    }
}