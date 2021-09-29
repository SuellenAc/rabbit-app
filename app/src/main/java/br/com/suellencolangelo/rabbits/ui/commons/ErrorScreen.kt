package br.com.suellencolangelo.rabbits.ui.commons

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import br.com.suellencolangelo.rabbits.R
import com.airbnb.lottie.compose.*

@Composable
fun ErrorScreen() {
    
    Box(contentAlignment = Alignment.Center) {
        val composition by rememberLottieComposition(
            spec = LottieCompositionSpec.RawRes(R.raw.error_animation)
        )
        val progress by animateLottieCompositionAsState(
            composition = composition,
            iterations = LottieConstants.IterateForever
        )

        LottieAnimation(composition = composition, progress = progress)
    }

}