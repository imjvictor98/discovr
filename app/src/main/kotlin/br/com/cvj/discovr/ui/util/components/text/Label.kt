package br.com.cvj.discovr.ui.util.components.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import br.com.cvj.discovr.ui.theme.Typography
import br.com.cvj.discovr.ui.util.components.text.base.BaseText

@Composable
fun LabelSmall(
    text: String,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = Typography.labelSmall.fontWeight!!,
    color: Color = Color.Black,
) {
    BaseText(
        modifier = modifier,
        text = text,
        color = color,
        fontWeight = fontWeight,
        style = Typography.labelSmall
    )
}

@Composable
fun LabelMedium(
    text: String,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = Typography.labelMedium.fontWeight!!,
    color: Color = Color.Black,
) {
    BaseText(
        modifier = modifier,
        text = text,
        fontWeight = fontWeight,
        color = color,
        style = Typography.labelMedium
    )
}

@Composable
fun LabelLarge(
    text: String,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = Typography.labelMedium.fontWeight!!,
    color: Color = Color.Black,
) {
    BaseText(
        modifier = modifier,
        text = text,
        fontWeight = fontWeight,
        color = color,
        style = Typography.labelLarge
    )
}

@Preview
@Composable
private fun LabelSmallPreview() {
    LabelSmall(text = "Label")
}

@Preview
@Composable
private fun LabelMediumPreview() {
    LabelMedium(text = "Label")
}

@Preview
@Composable
private fun LabelLargePreview() {
    LabelLarge(text = "Label")
}
