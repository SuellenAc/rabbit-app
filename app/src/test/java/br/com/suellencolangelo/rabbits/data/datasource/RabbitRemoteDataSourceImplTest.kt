package br.com.suellencolangelo.rabbits.data.datasource

import br.com.suellencolangelo.rabbits.DispatcherProvider
import br.com.suellencolangelo.rabbits.data.api.RabbitsApi
import br.com.suellencolangelo.rabbits.data.mapper.RabbitResponseToModelMapper
import io.mockk.mockk
import org.junit.Rule

class RabbitRemoteDataSourceImplTest {
    private val rabbitsApi: RabbitsApi = mockk()
    private val rabbitMapper: RabbitResponseToModelMapper = mockk()
    private val dispatchers: DispatcherProvider = mockk()

    @get:Rule


    private val datasource = RabbitRemoteDataSourceImpl(
        rabbitsApi = rabbitsApi,
        rabbitMapper = rabbitMapper,
        dispatchers = dispatchers
    )
}