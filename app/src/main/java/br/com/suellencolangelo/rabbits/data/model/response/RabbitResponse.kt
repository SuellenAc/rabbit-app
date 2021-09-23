package br.com.suellencolangelo.rabbits.data.model.response

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class RabbitResponse(
    val name: String,
    val description: String,
    val imageUrl:String
)
