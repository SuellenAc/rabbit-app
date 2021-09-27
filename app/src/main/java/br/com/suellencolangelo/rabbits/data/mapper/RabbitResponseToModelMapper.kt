package br.com.suellencolangelo.rabbits.data.mapper

import br.com.suellencolangelo.rabbits.Mapper
import br.com.suellencolangelo.rabbits.data.model.response.RabbitResponse
import br.com.suellencolangelo.rabbits.domain.model.RabbitModel
import javax.inject.Inject

class RabbitResponseToModelMapper @Inject constructor() : Mapper<RabbitResponse, RabbitModel> {

    override fun mapTo(from: RabbitResponse): RabbitModel = RabbitModel(
        name = from.name,
        description = from.description,
        imageUrl = from.imageUrl
    )
}