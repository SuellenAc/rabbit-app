package br.com.suellencolangelo.rabbits

interface Mapper<T, L> {
    fun mapTo(from: T): L
}