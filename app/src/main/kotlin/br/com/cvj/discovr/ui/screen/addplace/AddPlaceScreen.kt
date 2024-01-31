package br.com.cvj.discovr.ui.screen.addplace

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.cvj.discovr.R
import br.com.cvj.discovr.ui.util.components.stack.HStack
import br.com.cvj.discovr.ui.util.components.text.LabelMedium
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
        Card(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(8.dp),
            colors = CardColors(
                containerColor = Color.LightGray, // Replace with your desired color
                contentColor = Color.White,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.DarkGray
            )
        ) {
            HStack {
                Image(
                    modifier = Modifier
                        .width(100.dp)
                        .fillMaxHeight(),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.test),
                    contentDescription = " "
                )
                LabelMedium(modifier = Modifier.padding(start = 8.dp, top = 8.dp), text = "Jotaka")
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = false, backgroundColor = 0xfff)
@Composable
fun AddPlaceScreenPreview() {
    AddPlaceScreen()
}
