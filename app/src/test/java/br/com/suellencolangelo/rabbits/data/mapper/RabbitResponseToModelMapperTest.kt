package br.com.suellencolangelo.rabbits.data.mapper

import br.com.suellencolangelo.rabbits.data.model.response.RabbitResponse
import br.com.suellencolangelo.rabbits.domain.model.RabbitModel
import junit.framework.Assert.assertEquals
import org.junit.Test

class RabbitResponseToModelMapperTest {

    private val mapper = RabbitResponseToModelMapper()

    private val name = "Rabbit Name"
    private val description = "Rabbit Description"
    private val imageUrl = "ImageUrl"

    @Test
    fun mapTo_returnModel() {
        val response = RabbitResponse(
            name = name,
            description = description,
            imageUrl = imageUrl
        )

        val expected = RabbitModel(
            name = name,
            description = description,
            imageUrl = imageUrl
        )

        val actual = mapper.mapTo(response)

        assertEquals(expected, actual)
    }
}