package br.com.suellencolangelo.rabbits.data.datasource

import br.com.suellencolangelo.rabbits.domain.model.RabbitModel

interface RabbitRemoteDataSource {
    suspend fun getRandomRabbit() : Result<RabbitModel>
}