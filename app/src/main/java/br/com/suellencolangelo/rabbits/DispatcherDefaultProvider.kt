package br.com.suellencolangelo.rabbits

import kotlinx.coroutines.Dispatchers
import javax.inject.Inject


interface DispatcherProvider {
    fun getIO() = Dispatchers.IO
    fun getMain() = Dispatchers.Main
    fun getDefault() = Dispatchers.Default
}

class DispatcherDefaultProvider @Inject constructor(): DispatcherProvider