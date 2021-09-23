package br.com.suellencolangelo.rabbits.data.api

import br.com.suellencolangelo.rabbits.data.model.response.RabbitResponse
import retrofit2.Response
import retrofit2.http.GET

interface RabbitsApi {

    @GET("random-rabbit")
    suspend fun getRandomRabbit(): Response<RabbitResponse>

}