package com.xheghun.composecleanarchitecture.domain.model

import com.google.gson.annotations.SerializedName
import com.xheghun.composecleanarchitecture.data.remote.dto.CoinDTO

data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)

fun CoinDTO.toCoin(): Coin {
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}