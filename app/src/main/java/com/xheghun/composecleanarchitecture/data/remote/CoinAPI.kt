package com.xheghun.composecleanarchitecture.data.remote

import com.xheghun.composecleanarchitecture.data.remote.dto.CoinDTO
import com.xheghun.composecleanarchitecture.data.remote.dto.CoinDetailsDTO

import retrofit2.http.GET
import retrofit2.http.Path

interface CoinAPI {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDTO>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String) : CoinDetailsDTO
}