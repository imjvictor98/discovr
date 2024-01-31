package br.com.cvj.discovr.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.com.cvj.discovr.R.font.facundo_bold
import br.com.cvj.discovr.R.font.facundo_regular
import br.com.cvj.discovr.R.font.facundo_semibold
import br.com.cvj.discovr.R.font.facundo_thin

val facundoFamily = FontFamily(
    Font(facundo_thin, FontWeight.Thin),
    Font(facundo_regular, FontWeight.Normal),
    Font(facundo_semibold, FontWeight.Medium),
    Font(facundo_bold, FontWeight.Bold),
)

val Typography = Typography(
    labelSmall = TextStyle(
        fontFamily = facundoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.4.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = facundoFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 0.4.sp
    ),
    labelLarge = TextStyle(
        fontFamily = facundoFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        letterSpacing = 0.4.sp
    ),
)
