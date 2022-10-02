package com.xheghun.composecleanarchitecture.domain.use_cases.get_coin

import com.xheghun.composecleanarchitecture.common.Resource
import com.xheghun.composecleanarchitecture.domain.model.Coin
import com.xheghun.composecleanarchitecture.domain.model.CoinDetail
import com.xheghun.composecleanarchitecture.domain.model.toCoin
import com.xheghun.composecleanarchitecture.domain.model.toCoinDetail
import com.xheghun.composecleanarchitecture.domain.repo.CoinRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    val repo: CoinRepo,
) {
    operator fun invoke(id: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())

            val coins = repo.getCoinByID(id).toCoinDetail()

            emit(Resource.Success(coins))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "an unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Could not reach server. Check your internet connection"))
        }
    }

}