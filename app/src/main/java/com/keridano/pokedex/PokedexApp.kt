package com.keridano.pokedex

import android.app.Application
import android.content.Context
import com.keridano.pokedex.utils.repositoryModule
import com.keridano.pokedex.utils.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PokedexApp : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: PokedexApp? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()

        val context: Context = applicationContext()

        startKoin {
            androidContext(context)
            modules(listOf(repositoryModule, uiModule))
        }
    }
}
