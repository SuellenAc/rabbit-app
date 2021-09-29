package br.com.suellencolangelo.rabbits.domain.usecase

import br.com.suellencolangelo.rabbits.data.repository.RabbitsRepository
import br.com.suellencolangelo.rabbits.domain.model.RabbitModel
import javax.inject.Inject

interface GetRandomRabbitUseCase {
    suspend fun invoke() :  Result<RabbitModel>
}

class GetRandomRabbitImpl @Inject constructor(
    private val rabbitsRepository: RabbitsRepository
) : GetRandomRabbitUseCase {
    override suspend fun invoke(): Result<RabbitModel> = rabbitsRepository.getRandomRabbit()
}