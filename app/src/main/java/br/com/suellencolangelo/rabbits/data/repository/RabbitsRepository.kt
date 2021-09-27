package br.com.suellencolangelo.rabbits.data.repository

import br.com.suellencolangelo.rabbits.domain.model.RabbitModel

interface RabbitsRepository {
    suspend fun getRandomRabbit() : Result<RabbitModel>
}