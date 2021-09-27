package br.com.suellencolangelo.rabbits.di

import br.com.suellencolangelo.rabbits.data.datasource.RabbitRemoteDataSource
import br.com.suellencolangelo.rabbits.data.datasource.RabbitRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
abstract class DataModule {

    @Binds
    abstract fun bindsRabbitRemoteDataSource(
        dataSourceImpl: RabbitRemoteDataSourceImpl,
    ): RabbitRemoteDataSource
}