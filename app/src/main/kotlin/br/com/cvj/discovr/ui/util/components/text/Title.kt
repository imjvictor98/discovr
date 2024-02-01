package br.com.cvj.discovr.ui.util.components.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import br.com.cvj.discovr.ui.theme.Typography
import br.com.cvj.discovr.ui.util.components.text.base.BaseText

@Composable
fun TitleSmall(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
) {
    BaseText(
        modifier = modifier,
        text = text,
        color = color,
        style = Typography.titleSmall
    )
}

@Composable
fun TitleMedium(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
) {
    BaseText(
        modifier = modifier,
        text = text,
        color = color,
        style = Typography.titleMedium
    )
}

@Composable
fun TitleLarge(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
) {
    BaseText(
        modifier = modifier,
        text = text,
        color = color,
        style = Typography.titleLarge
    )
}

@Preview
@Composable
private fun TitleSmallPreview() {
    TitleSmall(text = "Title")
}

@Preview
@Composable
private fun TitleMediumPreview() {
    TitleMedium(text = "Title")
}

@Preview
@Composable
private fun TitleLargePreview() {
    TitleLarge(text = "Label")
}
