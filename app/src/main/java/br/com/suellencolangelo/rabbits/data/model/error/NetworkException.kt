package br.com.suellencolangelo.rabbits.data.model.error

sealed class BaseNetworkException : Exception() {
    object NetworkException : BaseNetworkException()
    object UnknownException : BaseNetworkException()
    object EmptyResponse: BaseNetworkException()
}