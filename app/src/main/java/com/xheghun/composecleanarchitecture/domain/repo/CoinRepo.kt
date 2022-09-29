package com.xheghun.composecleanarchitecture.domain.repo

import com.xheghun.composecleanarchitecture.data.remote.dto.CoinDTO
import com.xheghun.composecleanarchitecture.data.remote.dto.CoinDetailsDTO

interface CoinRepo {
    suspend fun getCoins() : List<CoinDTO>
    suspend fun getCoinByID(coinID: String) : CoinDetailsDTO
}