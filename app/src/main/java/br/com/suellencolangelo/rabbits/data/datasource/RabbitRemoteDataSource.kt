package br.com.suellencolangelo.rabbits.data.datasource

import br.com.suellencolangelo.rabbits.domain.model.RabbitModel

interface RabbitRemoteDataSource {
    fun getRandomRabbit() : Result<RabbitModel>
}