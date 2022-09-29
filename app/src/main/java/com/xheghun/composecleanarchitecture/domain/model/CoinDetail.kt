package com.xheghun.composecleanarchitecture.domain.model

import com.xheghun.composecleanarchitecture.data.remote.dto.CoinDetailsDTO
import com.xheghun.composecleanarchitecture.data.remote.dto.TeamMember

data class CoinDetail(
    val coinID: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)


fun CoinDetailsDTO.toCoinDetail(): CoinDetail {
    return CoinDetail(
        coinID = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team
    )
}