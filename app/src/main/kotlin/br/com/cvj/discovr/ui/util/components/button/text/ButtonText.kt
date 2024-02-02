package br.com.cvj.discovr.ui.util.components.button.text

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.cvj.discovr.ui.util.components.text.LabelLarge

@Composable
fun ButtonText(
    text: String,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    textColor: Color = ButtonDefaults.textButtonColors().contentColor,
    onClick: () -> Unit
) {
    TextButton(onClick = onClick, contentPadding = contentPadding, modifier = modifier) {
        LabelLarge(text = text, color = textColor)
    }
}

@Preview
@Composable
fun ButtonTextPreview() {
    ButtonText(text = "Text Button", onClick = {})
}
