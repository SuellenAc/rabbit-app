package br.com.suellencolangelo.rabbits.ui.random

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.suellencolangelo.rabbits.domain.usecase.GetRandomRabbitUseCase
import br.com.suellencolangelo.rabbits.ui.mapper.RabbitModelToUiModelMapper
import br.com.suellencolangelo.rabbits.ui.model.RabbitUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomRabbitViewModel @Inject constructor(
    private val getRandomRabbitUseCase: GetRandomRabbitUseCase,
    private val rabbitMapper: RabbitModelToUiModelMapper,
) : ViewModel() {
    private val _state = MutableLiveData<UiState>().apply { value = UiState.Loading }
    val state: LiveData<UiState> = _state

    fun getRandomRabbit() = viewModelScope.launch {
        _state.value = UiState.Loading
        getRandomRabbitUseCase.invoke().onSuccess {
            _state.value = UiState.Success(rabbitMapper.mapTo(it))
        }.onFailure {
            _state.value = UiState.Error
        }
    }
}

sealed class UiState {
    object Loading : UiState()
    object Error : UiState()
    data class Success(val rabbit: RabbitUiModel) : UiState()
}