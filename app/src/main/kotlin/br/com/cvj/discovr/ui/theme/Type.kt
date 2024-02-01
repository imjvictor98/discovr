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
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.4.sp,
    ),
    labelMedium = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 0.4.sp
    ),
    labelLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        letterSpacing = 0.4.sp
    ),
    titleSmall = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.4.sp
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        letterSpacing = 0.4.sp
    ),
    titleLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        letterSpacing = 0.4.sp
    ),
)
