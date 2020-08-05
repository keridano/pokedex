package com.keridano.pokedex

import android.util.Log
import com.keridano.pokedex.domain.GetPokemonListUseCase
import com.keridano.pokedex.utils.TAG
import com.keridano.pokedex.utils.repositoryModule
import com.keridano.pokedex.utils.uiModule
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class ExampleUnitTest : KoinTest {

    private val getPokemonListUseCase: GetPokemonListUseCase by inject()

    @Before
    fun setup() {
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        startKoin {
            modules(listOf(repositoryModule, uiModule))
        }
    }

    @Test
    fun getListOfPokemon() {

        //TODO to be completed

        getPokemonListUseCase.getPokemonList()
            .subscribeOn(Schedulers.io())
            .toObservable()
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                Log.d(TAG, it.toString())
            }
            .onErrorReturn {
                throw it
            }
    }
}