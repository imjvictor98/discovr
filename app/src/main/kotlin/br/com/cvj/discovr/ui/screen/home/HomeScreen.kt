package br.com.cvj.discovr.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.cvj.discovr.R
import br.com.cvj.discovr.navigation.destinations.AddPlaceRouteDestination
import br.com.cvj.discovr.ui.theme.Colors
import br.com.cvj.discovr.ui.util.components.button.fab.ButtonFab
import br.com.cvj.discovr.ui.util.components.button.solid.ButtonSolid
import br.com.cvj.discovr.ui.util.components.button.solid.ButtonSolidType
import br.com.cvj.discovr.ui.util.components.loading.LoadingScreen
import br.com.cvj.discovr.ui.util.components.stack.HStack
import br.com.cvj.discovr.ui.util.components.stack.VStack
import br.com.cvj.discovr.ui.util.components.text.LabelLarge
import br.com.cvj.discovr.ui.util.components.text.LabelSmall
import br.com.cvj.discovr.ui.util.components.text.TitleMedium
import br.com.cvj.discovr.util.AppLanguage
import br.com.cvj.discovr.util.AppTheme
import br.com.cvj.discovr.util.ext.context.instagram.instagramActions
import br.com.cvj.discovr.util.ext.context.uber.uberActions
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.brands.Instagram
import compose.icons.fontawesomeicons.brands.Uber
import compose.icons.fontawesomeicons.solid.Map

@RootNavGraph(start = true)
@Destination
@Composable
fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel(),
    navigator: DestinationsNavigator? = null
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(
        navigator = navigator,
        uiState = uiState,
    )
}

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator? = null
) {
    when (uiState) {
        HomeUiState.Loading -> LoadingScreen()

        is HomeUiState.Success -> {
            val context = LocalContext.current

            Box(modifier = Modifier.fillMaxSize()) {
                HStack(
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .background(Color.White, shape = RoundedCornerShape(8.dp))
                        .then(modifier),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Top
                ) {
                    VStack() {
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(
                                    RoundedCornerShape(8.dp)
                                ),
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
                                TitleMedium(
                                    modifier = Modifier.padding(top = 8.dp),
                                    text = "Jotaka, Restaurante"
                                )
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

                            val actionButtonsScroll = rememberScrollState()
                            HStack(
                                modifier = Modifier.horizontalScroll(actionButtonsScroll),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                ButtonSolid(
                                    text = "Ir de Uber",
                                    buttonType = ButtonSolidType.FILLED,
                                    backgroundColor = Colors.Blue100,
                                    textColor = Colors.Blue700,
                                    onClick = {
                                        context.uberActions.pickUpUber()
                                    },
                                    contentStart = {
                                        Icon(
                                            modifier = Modifier.size(24.dp),
                                            imageVector = FontAwesomeIcons.Brands.Uber,
                                            tint = Colors.Blue700,
                                            contentDescription = "Ir de Uber",
                                        )
                                        Spacer(modifier = Modifier.size(8.dp))
                                    }
                                )

                                ButtonSolid(
                                    text = "Abrir no Maps",
                                    buttonType = ButtonSolidType.FILLED,
                                    backgroundColor = Colors.Blue100,
                                    textColor = Colors.Blue700,
                                    onClick = {},
                                    contentStart = {
                                        Icon(
                                            modifier = Modifier.size(24.dp),
                                            imageVector = FontAwesomeIcons.Solid.Map,
                                            tint = Colors.Blue700,
                                            contentDescription = "Abri no Maps"
                                        )
                                        Spacer(modifier = Modifier.size(8.dp))
                                    }
                                )

                                ButtonSolid(
                                    text = "@jotakacozinhabar",
                                    buttonType = ButtonSolidType.FILLED,
                                    backgroundColor = Colors.Blue100,
                                    textColor = Colors.Blue700,
                                    onClick = {
                                        context.instagramActions.openAccount("jotakacozinhabar")
                                    },
                                    contentStart = {
                                        Icon(
                                            modifier = Modifier.size(24.dp),
                                            imageVector = FontAwesomeIcons.Brands.Instagram,
                                            tint = Colors.Blue700,
                                            contentDescription = "Abri no Maps"
                                        )
                                        Spacer(modifier = Modifier.size(8.dp))
                                    }
                                )
                            }
                        }
                    }
                }
                ButtonFab(
                    icon = Icons.Default.Add,
                    onClick = { navigator?.navigate(AddPlaceRouteDestination()) },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(16.dp)
                        .navigationBarsPadding(),
                )
            }
        }

        is HomeUiState.Error -> Unit
    }
}

sealed interface ActiveDialog {
    data object None : ActiveDialog
    data object Language : ActiveDialog
    data object Theme : ActiveDialog
}

@Preview
@Composable
private fun HomeScreenLoadingPreview() {
    HomeScreen(
        uiState = HomeUiState.Loading
    )
}

@Preview
@Composable
private fun HomeScreenContentPreview() {
    HomeScreen(
        uiState = HomeUiState.Success(language = AppLanguage.English, theme = AppTheme.Light)
    )
}
