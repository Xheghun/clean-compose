package com.xheghun.composecleanarchitecture.data.repo

import com.xheghun.composecleanarchitecture.data.remote.CoinAPI
import com.xheghun.composecleanarchitecture.data.remote.dto.CoinDTO
import com.xheghun.composecleanarchitecture.data.remote.dto.CoinDetailsDTO
import com.xheghun.composecleanarchitecture.domain.repo.CoinRepo
import javax.inject.Inject

class CoinRepoImpl @Inject constructor(
    private val api: CoinAPI
) : CoinRepo {
    override suspend fun getCoins(): List<CoinDTO> {
        return api.getCoins()
    }

    override suspend fun getCoinByID(coinID: String): CoinDetailsDTO {
        return api.getCoinById(coinID)
    }
}