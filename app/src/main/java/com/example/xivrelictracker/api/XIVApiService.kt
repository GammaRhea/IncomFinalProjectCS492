package com.example.xivrelictracker.api

import com.example.xivrelictracker.data.QuestObject
import com.example.xivrelictracker.data.XIVApiJsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface XIVApiService {
    @GET("quest")
    suspend fun loadQuestList(
        @Query("qID") questID: String?,
        @Query("lang") language: String?,
        @Query("appid") apiKey: String
    ) : QuestObject

    companion object {
        private const val BASE_URL = "https://xivapi.com/"

        fun create() : XIVApiService {
            val moshi = Moshi.Builder()
                .add(XIVApiJsonAdapter())
                .addLast(KotlinJsonAdapterFactory())
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create(XIVApiService::class.java)
        }
    }
}