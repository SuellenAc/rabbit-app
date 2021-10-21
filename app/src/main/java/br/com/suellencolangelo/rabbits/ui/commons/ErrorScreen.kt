package br.com.suellencolangelo.rabbits.ui.commons

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.suellencolangelo.rabbits.R
import com.airbnb.lottie.compose.*

@Composable
fun ErrorScreen(
    onTryAgainClick: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.Center, 
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        ErrorAnimation()
        Button(onClick = { onTryAgainClick() }) {
            Text(text = stringResource(id = R.string.try_again))
        }
    }

}

@Composable
private fun ErrorAnimation() {
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.error_animation)
    )
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
    LottieAnimation(
        composition = composition,
        progress = progress,
        modifier = Modifier.size(200.dp)
    )
}

@Composable
@Preview
fun ErrorScreenPreview(){
    ErrorScreen{}
}