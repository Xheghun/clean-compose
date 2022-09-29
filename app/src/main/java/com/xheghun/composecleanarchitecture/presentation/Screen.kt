package com.xheghun.composecleanarchitecture.presentation

sealed class Screen(val route: String) {
    object CoinListScreen: Screen("coin_list")
    object CoinDetails: Screen("coin_details")
}