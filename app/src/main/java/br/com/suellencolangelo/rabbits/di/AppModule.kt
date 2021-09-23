package br.com.suellencolangelo.rabbits.di

import br.com.suellencolangelo.rabbits.Constants
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Singleton
    @Provides
    fun provideOkHttpClient() = OkHttpClient.Builder().build()


    @Singleton
    @Provides
    fun provideMoshi() = Moshi.Builder().build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi, baseUrl: String) =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()

}