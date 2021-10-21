package br.com.suellencolangelo.rabbits.ui.random

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RandomRabbitFragment : Fragment() {

    private val viewModel: RandomRabbitViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                RandomRabbitScreen(
                    uiState = viewModel.state.value,
                    onGetNextClick = { viewModel.getRandomRabbit() },
                    onTryAgainClick = { viewModel.getRandomRabbit() }
                )
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getRandomRabbit()
    }

    companion object {
        fun newInstance() = RandomRabbitFragment()
    }
}