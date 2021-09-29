package br.com.suellencolangelo.rabbits.di

import br.com.suellencolangelo.rabbits.data.datasource.RabbitRemoteDataSource
import br.com.suellencolangelo.rabbits.data.datasource.RabbitRemoteDataSourceImpl
import br.com.suellencolangelo.rabbits.data.repository.RabbitsRepository
import br.com.suellencolangelo.rabbits.data.repository.RabbitsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindsRabbitRemoteDataSource(
        dataSourceImpl: RabbitRemoteDataSourceImpl,
    ): RabbitRemoteDataSource

    @Binds
    abstract fun bindsRabbitsRepository(
        repository: RabbitsRepositoryImpl,
    ): RabbitsRepository
}