package br.com.cvj.discovr.ui.util.components.button

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.cvj.discovr.ui.theme.Colors
import br.com.cvj.discovr.ui.util.components.stack.HStack
import br.com.cvj.discovr.ui.util.components.text.LabelSmall

@Composable
fun SingleRadioButton(
    modifier: Modifier = Modifier,
    optionText: String? = null,
) {
    var isSelected by remember {
        mutableStateOf(false)
    }

    HStack(modifier = Modifier.padding(end = 16.dp), verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            modifier = modifier,
            selected = isSelected,
            onClick = { isSelected = !isSelected },
            colors = RadioButtonColors(
                selectedColor = Colors.ColorTint,
                unselectedColor = RadioButtonDefaults.colors().unselectedColor,
                disabledSelectedColor = RadioButtonDefaults.colors().disabledSelectedColor,
                disabledUnselectedColor = RadioButtonDefaults.colors().disabledUnselectedColor,

            )
        )
        optionText?.let {
            LabelSmall(text = it)
        }
    }
}

@Preview(showSystemUi = true, showBackground = false, backgroundColor = 0xfff)
@Composable
fun SingleRadioButtonPreview() {
    SingleRadioButton(
        optionText = "Jotaka",
    )
}

@Preview(showSystemUi = true, showBackground = false, backgroundColor = 0xfff)
@Composable
fun SingleRadioButtonNoTextPreview() {
    SingleRadioButton()
}
