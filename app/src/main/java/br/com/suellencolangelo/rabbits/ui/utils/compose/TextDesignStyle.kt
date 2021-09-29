package br.com.suellencolangelo.rabbits.ui.utils.compose

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.com.suellencolangelo.rabbits.ui.utils.compose.robotoFontFamily

object TextDesignStyle {
    val Header1 =
        TextStyle(fontFamily = robotoFontFamily, fontWeight = FontWeight.Medium, fontSize = 20.sp)
    val Header2 =
        TextStyle(fontFamily = robotoFontFamily, fontWeight = FontWeight.Medium, fontSize = 18.sp)
    val Header3 =
        TextStyle(fontFamily = robotoFontFamily, fontWeight = FontWeight.Medium, fontSize = 16.sp)
    val Header4 =
        TextStyle(fontFamily = robotoFontFamily, fontWeight = FontWeight.Medium, fontSize = 14.sp)
    val SubTitle1 =
        TextStyle(fontFamily = robotoFontFamily, fontWeight = FontWeight.Normal, fontSize = 18.sp)
    val SubTitle2 =
        TextStyle(fontFamily = robotoFontFamily, fontWeight = FontWeight.Normal, fontSize = 16.sp)
    val SubTitle3 =
        TextStyle(fontFamily = robotoFontFamily, fontWeight = FontWeight.Light, fontSize = 14.sp)
}