package br.com.suellencolangelo.rabbits.ui.mapper

import br.com.suellencolangelo.rabbits.Mapper
import br.com.suellencolangelo.rabbits.data.model.response.RabbitResponse
import br.com.suellencolangelo.rabbits.domain.model.RabbitModel
import br.com.suellencolangelo.rabbits.ui.model.RabbitUiModel
import javax.inject.Inject

class RabbitModelToUiModelMapper @Inject constructor() : Mapper<RabbitModel, RabbitUiModel> {

    override fun mapTo(from: RabbitModel): RabbitUiModel = RabbitUiModel(
        name = from.name,
        description = from.description,
        imageUrl = from.imageUrl
    )
}