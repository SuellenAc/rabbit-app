package br.com.suellencolangelo.rabbits.ui.random

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
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
    var state: MutableState<UiState> = mutableStateOf(UiState.Loading)
        private set

    fun getRandomRabbit() {
        viewModelScope.launch {
            state.value = UiState.Loading
            getRandomRabbitUseCase.invoke().onSuccess {
                state.value = UiState.Success(rabbitMapper.mapTo(it))
            }.onFailure {
                state.value = UiState.Error
            }
        }
    }
}

sealed class UiState {
    object Loading : UiState()
    object Error : UiState()
    data class Success(val rabbit: RabbitUiModel) : UiState()
}