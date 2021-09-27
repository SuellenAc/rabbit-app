package br.com.suellencolangelo.rabbits.di

import br.com.suellencolangelo.rabbits.DispatcherDefaultProvider
import br.com.suellencolangelo.rabbits.DispatcherProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class UtilsModule {

    @Binds
    abstract fun bindDispatcherProvider(dispatcher: DispatcherDefaultProvider): DispatcherProvider
}