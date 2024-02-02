package br.com.cvj.discovr.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.cvj.discovr.R
import br.com.cvj.discovr.navigation.destinations.AddPlaceRouteDestination
import br.com.cvj.discovr.ui.screen.home.components.LanguagePickerDialog
import br.com.cvj.discovr.ui.screen.home.components.ThemePickerDialog
import br.com.cvj.discovr.ui.util.components.button.fab.ButtonFab
import br.com.cvj.discovr.ui.util.components.loading.LoadingScreen
import br.com.cvj.discovr.util.AppLanguage
import br.com.cvj.discovr.util.AppTheme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

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
        onChangeTheme = viewModel::updateTheme,
        onChangeLanguage = viewModel::updateLanguage
    )
}

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onChangeTheme: (AppTheme) -> Unit,
    onChangeLanguage: (AppLanguage) -> Unit,
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator? = null
) {
    when (uiState) {
        HomeUiState.Loading -> LoadingScreen()

        is HomeUiState.Success -> {
            val (activeDialog, setActiveDialog) = remember {
                mutableStateOf<ActiveDialog>(
                    ActiveDialog.None
                )
            }

            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = { setActiveDialog(ActiveDialog.Language) }) {
                        Text(text = stringResource(id = R.string.change_language))
                    }

                    Button(onClick = { setActiveDialog(ActiveDialog.Theme) }) {
                        Text(text = stringResource(R.string.change_theme))
                    }

                    when (activeDialog) {
                        ActiveDialog.None -> Unit

                        ActiveDialog.Language -> {
                            LanguagePickerDialog(
                                selectedLanguage = uiState.language,
                                onDismiss = { setActiveDialog(ActiveDialog.None) },
                                onConfirm = onChangeLanguage
                            )
                        }

                        ActiveDialog.Theme -> {
                            ThemePickerDialog(
                                selectedTheme = uiState.theme,
                                onDismiss = { setActiveDialog(ActiveDialog.None) },
                                onConfirm = onChangeTheme
                            )
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
        uiState = HomeUiState.Loading,
        onChangeTheme = { },
        onChangeLanguage = { },
    )
}

@Preview
@Composable
private fun HomeScreenContentPreview() {
    HomeScreen(
        uiState = HomeUiState.Success(language = AppLanguage.English, theme = AppTheme.Light),
        onChangeTheme = { },
        onChangeLanguage = { }
    )
}
