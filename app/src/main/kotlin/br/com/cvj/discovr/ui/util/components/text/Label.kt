package br.com.cvj.discovr.ui.util.components.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import br.com.cvj.discovr.ui.theme.Typography

@Composable
fun LabelSmall(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        style = Typography.labelSmall
    )
}

@Composable
fun LabelMedium(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        style = Typography.labelMedium
    )
}

@Composable
fun LabelLarge(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        style = Typography.labelLarge
    )
}

@Preview(showSystemUi = true, showBackground = true, backgroundColor = 0xfff)
@Composable
fun LabelSmallPreview() {
    LabelSmall(text = "Label")
}

@Preview(showSystemUi = true, showBackground = true, backgroundColor = 0xfff)
@Composable
fun LabelMediumPreview() {
    LabelMedium(text = "Label")
}

@Preview(showSystemUi = true, showBackground = true, backgroundColor = 0xfff)
@Composable
fun LabelLargereview() {
    LabelLarge(text = "Label")
}
