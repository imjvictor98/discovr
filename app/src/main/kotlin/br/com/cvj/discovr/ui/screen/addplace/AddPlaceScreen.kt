package br.com.cvj.discovr.ui.screen.addplace

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.cvj.discovr.R
import br.com.cvj.discovr.R.drawable.ic_99_yellow
import br.com.cvj.discovr.ui.theme.Colors
import br.com.cvj.discovr.ui.util.components.button.solid.ButtonSolid
import br.com.cvj.discovr.ui.util.components.button.solid.ButtonSolidType
import br.com.cvj.discovr.ui.util.components.button.text.ButtonText
import br.com.cvj.discovr.ui.util.components.stack.HStack
import br.com.cvj.discovr.ui.util.components.stack.VStack
import br.com.cvj.discovr.ui.util.components.text.LabelLarge
import br.com.cvj.discovr.ui.util.components.text.LabelSmall
import br.com.cvj.discovr.ui.util.components.text.TitleMedium
import com.ramcosta.composedestinations.annotation.Destination
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.brands.Uber

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
    val gradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFFF58529),
            Color(0xFFDD2A7B),
            Color(0xFF8134AF),
            Color(0xFF515BD4)
        )
    )
    HStack(
        modifier = Modifier
            .background(color = Colors.BackgroundColor)
            .fillMaxSize()
            .safeContentPadding()
            .then(modifier),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top
    ) {
        VStack {
            Image(
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.test),
                contentDescription = " "
            )

            VStack(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                VStack(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    TitleMedium(modifier = Modifier.padding(top = 8.dp), text = "Jotaka, Restaurante")
                    LabelSmall(
                        modifier = Modifier.padding(bottom = 4.dp),
                        text = "Av. Parque Águas Claras - Águas Claras, Brasília - DF",
                        color = Color.DarkGray
                    )

                    HStack(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        LabelSmall(text = "Aberto", color = Colors.Green400)
                        LabelLarge(text = "•", color = Color.Gray)
                        LabelSmall(text = "Fecha às 00:30", color = Color.Gray)
                        LabelLarge(text = "•", color = Color.Gray)
                        LabelSmall(text = "$$$", color = Color.Gray)
                    }
                }

                ButtonSolid(
                    text = "Horários de funcionamento",
                    buttonType = ButtonSolidType.FILLED,
                    textColor = ButtonDefaults.textButtonColors().contentColor,
                    backgroundColor = Color.Transparent,
                    contentPadding = PaddingValues(0.dp),
                    onClick = {}
                )

                HStack(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    ButtonSolid(
                        text = "Ir de Uber",
                        buttonType = ButtonSolidType.FILLED,
                        onClick = {},
                        contentStart = {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                imageVector = FontAwesomeIcons.Brands.Uber,
                                tint = Colors.Black100,
                                contentDescription = "Ir de Uber",
                            )
                            Spacer(modifier = Modifier.size(8.dp))
                        }
                    )

                    ButtonSolid(
                        text = "Ir de 99",
                        buttonType = ButtonSolidType.FILLED,
                        onClick = {},
                        contentStart = {
                            Image(
                                modifier = Modifier.size(24.dp),
                                painter = painterResource(id = ic_99_yellow),
                                contentDescription = "99",
                            )
                            Spacer(modifier = Modifier.size(8.dp))
                        }
                    )
                }

                ButtonText(
                    text = "@jotaka_restaurante",
                    onClick = {}
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = false, backgroundColor = 0xfff)
@Composable
fun AddPlaceScreenPreview() {
    AddPlaceScreen()
}
