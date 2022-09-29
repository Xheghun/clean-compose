package com.xheghun.composecleanarchitecture.presentation.coin_details

import com.xheghun.composecleanarchitecture.domain.model.Coin
import com.xheghun.composecleanarchitecture.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error:String = ""
)