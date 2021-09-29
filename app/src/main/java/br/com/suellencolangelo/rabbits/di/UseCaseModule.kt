package br.com.suellencolangelo.rabbits.di

import br.com.suellencolangelo.rabbits.domain.usecase.GetRandomRabbitImpl
import br.com.suellencolangelo.rabbits.domain.usecase.GetRandomRabbitUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindsGetRandomRabbitUseCase(useCase: GetRandomRabbitImpl): GetRandomRabbitUseCase
}