package br.com.suellencolangelo.rabbits.data.repository

import br.com.suellencolangelo.rabbits.data.datasource.RabbitRemoteDataSource
import br.com.suellencolangelo.rabbits.domain.model.RabbitModel
import javax.inject.Inject

class RabbitsRepositoryImpl @Inject constructor(
    private val remoteDataSource: RabbitRemoteDataSource,
) : RabbitsRepository {

    override suspend fun getRandomRabbit(): Result<RabbitModel> {
        return remoteDataSource.getRandomRabbit()
    }
}