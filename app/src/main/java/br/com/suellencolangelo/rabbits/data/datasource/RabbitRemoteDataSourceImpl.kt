package br.com.suellencolangelo.rabbits.data.datasource

import br.com.suellencolangelo.rabbits.DispatcherProvider
import br.com.suellencolangelo.rabbits.data.api.RabbitsApi
import br.com.suellencolangelo.rabbits.data.mapper.RabbitResponseToModelMapper
import br.com.suellencolangelo.rabbits.data.model.error.BaseNetworkException
import br.com.suellencolangelo.rabbits.domain.model.RabbitModel
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class RabbitRemoteDataSourceImpl @Inject constructor(
    private val rabbitsApi: RabbitsApi,
    private val rabbitMapper: RabbitResponseToModelMapper,
    private val dispatchers: DispatcherProvider
) : RabbitRemoteDataSource, CoroutineScope by CoroutineScope(dispatchers.getIO()) {

    override suspend fun getRandomRabbit(): Result<RabbitModel> = try {
        val response = rabbitsApi.getRandomRabbit()
        when {
            !response.isSuccessful -> Result.failure(BaseNetworkException.NetworkException)
            else -> {
                response.body()?.let {
                    Result.success(rabbitMapper.mapTo(it))
                } ?: Result.failure(BaseNetworkException.EmptyResponse)
            }
        }
    } catch (exception: Exception) {
        Result.failure(BaseNetworkException.UnknownException)
    }
}