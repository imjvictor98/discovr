package br.com.cvj.discovr.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.com.cvj.discovr.R.font.urbanist_bold
import br.com.cvj.discovr.R.font.urbanist_medium
import br.com.cvj.discovr.R.font.urbanist_regular
import br.com.cvj.discovr.R.font.urbanist_thin

val urbanFamily = FontFamily(
    Font(urbanist_thin, FontWeight.Thin),
    Font(urbanist_regular, FontWeight.Normal),
    Font(urbanist_medium, FontWeight.Medium),
    Font(urbanist_bold, FontWeight.Bold),
)

val Typography = Typography(
    labelSmall = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        fontFamily = urbanFamily,
        letterSpacing = 0.4.sp,
    ),
    labelMedium = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        fontFamily = urbanFamily,
        letterSpacing = 0.4.sp
    ),
    labelLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        fontFamily = urbanFamily,
        letterSpacing = 0.4.sp
    ),
    titleSmall = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        fontFamily = urbanFamily,
        letterSpacing = 0.4.sp
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        fontFamily = urbanFamily,
        letterSpacing = 0.4.sp
    ),
    titleLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        fontFamily = urbanFamily,
        letterSpacing = 0.4.sp
    ),
)
