package com.xheghun.composecleanarchitecture.domain.use_cases.get_coins

import com.xheghun.composecleanarchitecture.common.Resource
import com.xheghun.composecleanarchitecture.domain.model.Coin
import com.xheghun.composecleanarchitecture.domain.model.toCoin
import com.xheghun.composecleanarchitecture.domain.repo.CoinRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repo: CoinRepo
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())

            val coins = repo.getCoins().map { it.toCoin() }

            emit(Resource.Success(coins))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "an unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Could not reach server. Check your internet connection"))
        }
    }
}