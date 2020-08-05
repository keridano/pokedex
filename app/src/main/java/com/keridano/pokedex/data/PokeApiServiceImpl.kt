package com.keridano.pokedex.data

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.keridano.pokedex.model.ApiResource
import com.keridano.pokedex.model.NamedApiResource
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

internal class PokeApiServiceImpl(
    private val config: ClientConfig
) : PokeApiService by Retrofit.Builder()
    .baseUrl(config.rootUrl)
    .addConverterFactory(
        GsonConverterFactory.create(
            GsonBuilder().apply {
                setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                registerTypeAdapter(
                    TypeToken.get(ApiResource::class.java).type,
                    ApiResourceAdapter()
                )
                registerTypeAdapter(
                    TypeToken.get(NamedApiResource::class.java).type,
                    NamedApiResourceAdapter()
                )
            }.create()
        )
    )
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .client(OkHttpClient.Builder().(config.okHttpConfig)().build())
    .build()
    .create(PokeApiService::class.java)