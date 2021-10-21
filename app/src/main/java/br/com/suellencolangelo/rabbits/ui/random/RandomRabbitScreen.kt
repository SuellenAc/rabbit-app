package br.com.suellencolangelo.rabbits.ui.random

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.suellencolangelo.rabbits.R
import br.com.suellencolangelo.rabbits.ui.commons.ErrorScreen
import br.com.suellencolangelo.rabbits.ui.commons.LoadingScreen
import br.com.suellencolangelo.rabbits.ui.model.RabbitUiModel
import br.com.suellencolangelo.rabbits.ui.utils.compose.TextDesignStyle
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation

@ExperimentalCoilApi
@Composable
fun RandomRabbitScreen(
    uiState: UiState,
    onGetNextClick: () -> Unit,
    onTryAgainClick: () -> Unit,
) {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Toolbar()
            when (uiState) {
                UiState.Error -> ErrorScreen(onTryAgainClick)
                UiState.Loading -> LoadingScreen()
                is UiState.Success -> SuccessScreen(uiState.rabbit, onGetNextClick)
            }
        }
    }
}

@Composable
private fun SuccessScreen(
    rabbit: RabbitUiModel,
    onGetNextClick: () -> Unit
) {
    RabbitAvatar(rabbit)
    Name(rabbit)
    Description(rabbit)
    GetNextButton(onGetNextClick)
}

@Composable
private fun GetNextButton(onGetNextClick: () -> Unit) {
    Button(onClick = { onGetNextClick() }) {
        Text(text = stringResource(id = R.string.random_rabbits_next), color = Color.White)
    }
}

@Composable
private fun Description(rabbit: RabbitUiModel) {
    Text(
        text = rabbit.description,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp, 16.dp, 16.dp),
        textAlign = TextAlign.Start,
        style = TextDesignStyle.SubTitle2
    )
}

@Composable
private fun Name(rabbit: RabbitUiModel) {
    Text(
        text = rabbit.name,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 16.dp, 16.dp, 8.dp),
        textAlign = TextAlign.Start,
        style = TextDesignStyle.Header3
    )
}

@Composable
private fun Toolbar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .requiredHeight(48.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Text(text = stringResource(id = R.string.random_rabbits_screen_title), color = Color.White)
    }
}

@ExperimentalCoilApi
@Composable
private fun RabbitAvatar(rabbit: RabbitUiModel) {
    val imageCorner = with(LocalDensity.current) { 8.dp.toPx() }
    val painter = rememberImagePainter(data = rabbit.imageUrl, builder = {
        transformations(
            RoundedCornersTransformation(imageCorner, imageCorner, imageCorner, imageCorner)
        )
    })
    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .requiredHeight(300.dp)
            .fillMaxWidth()
    )
}

@ExperimentalCoilApi
@Composable
@Preview
fun RandomRabbitScreenPreview() {
    val stubRabbit = RabbitUiModel(
        "Maria",
        "A Happy little rabbit! Maria likes rainy days.",
        ""
    )
    RandomRabbitScreen(UiState.Success(stubRabbit), {}) {}
}
