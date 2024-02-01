package br.com.cvj.discovr.ui.screen.addplace

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.cvj.discovr.R
import br.com.cvj.discovr.ui.util.components.stack.HStack
import br.com.cvj.discovr.ui.util.components.stack.VStack
import br.com.cvj.discovr.ui.util.components.text.LabelMedium
import br.com.cvj.discovr.ui.util.components.text.TitleLarge
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination
fun AddPlaceRoute() {
    AddPlaceScreen()
}

@Composable
fun AddPlaceScreen(
    modifier: Modifier = Modifier,
//    uiState: AddPlaceUiState,
) {
    HStack(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .safeContentPadding()
            .then(modifier),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top
    ) {
        VStack(modifier = Modifier.padding(8.dp)) {
            Image(
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.test),
                contentDescription = " "
            )
            TitleLarge(modifier = Modifier.padding(top = 8.dp), text = "Jotaka, Restaurante")
        }
    }
}

@Preview(showSystemUi = true, showBackground = false, backgroundColor = 0xfff)
@Composable
fun AddPlaceScreenPreview() {
    AddPlaceScreen()
}
