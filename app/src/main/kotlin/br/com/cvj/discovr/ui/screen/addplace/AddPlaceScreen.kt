package br.com.cvj.discovr.ui.screen.addplace

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.cvj.discovr.ui.util.components.button.SingleRadioButton
import br.com.cvj.discovr.ui.util.components.stack.HStack

@Composable
fun AddPlaceRoute() {
    AddPlaceScreen()
}

@Composable
fun AddPlaceScreen(
    modifier: Modifier = Modifier,
//    uiState: AddPlaceUiState,
) {
    HStack(modifier = Modifier.fillMaxSize().then(modifier)) {
        SingleRadioButton(optionText = "Jotaka")
    }
}

@Preview(showBackground = true, backgroundColor = 0xfff)
@Composable
fun AddPlaceScreenPreview() {
    AddPlaceScreen()
}
