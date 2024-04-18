package br.com.cvj.discovr.ui.screen.addplace

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.cvj.discovr.domain.model.google.place.GooglePlaces
import br.com.cvj.discovr.ui.theme.Colors
import br.com.cvj.discovr.ui.theme.Typography
import br.com.cvj.discovr.ui.util.components.stack.HStack
import br.com.cvj.discovr.ui.util.components.stack.VStack
import br.com.cvj.discovr.ui.util.components.text.LabelLarge
import br.com.cvj.discovr.ui.util.components.text.LabelSmall
import br.com.cvj.discovr.ui.util.components.text.TitleLarge
import br.com.cvj.discovr.ui.util.components.text.TitleMedium
import br.com.cvj.discovr.util.ext.context.removeAfterComma
import com.ramcosta.composedestinations.annotation.Destination
import compose.icons.EvaIcons
import compose.icons.evaicons.Outline
import compose.icons.evaicons.outline.Search

@Composable
@Destination
fun AddPlaceRoute(
    viewModel: AddPlaceViewModel = hiltViewModel()
) {
    val addPlaceUiState by viewModel.addPlaceUiState.collectAsStateWithLifecycle()
    val stepUiState by viewModel.stepUiState.collectAsStateWithLifecycle()

    AddPlaceScreen(
        addPlaceUiState = addPlaceUiState,
        stepUiState = stepUiState,
        searchPlaces = viewModel::searchPlaces,
        addPlace = viewModel::addPlace,
    )
}

@Composable
fun AddPlaceScreen(
    addPlaceUiState: AddPlaceUiState,
    stepUiState: AddPlaceStepUiState,
    searchPlaces: (name: String) -> Unit,
    modifier: Modifier = Modifier,
    addPlace: (place: GooglePlaces.Place) -> Unit,
) {
    var searchQuery by remember { mutableStateOf("") }
    var instagramQuery by remember { mutableStateOf("") }
    var selectedItem by remember { mutableStateOf<GooglePlaces.Place?>(null) }
    var isDropdownExpanded by remember { mutableStateOf(false) }
    var textFieldWidth by remember { mutableStateOf(0.dp) }
    val density = LocalDensity.current
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    VStack(
        modifier = Modifier
    ) {
        TitleLarge(modifier = Modifier.padding(top = 24.dp, start = 24.dp), text = "Local")

        HStack(modifier = Modifier.padding(start = 24.dp, end = 24.dp)) {
            OutlinedTextField(
                singleLine = true,
                textStyle = Typography.labelLarge.copy(fontWeight = FontWeight.Normal),
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester)
                    .onGloballyPositioned {
                        textFieldWidth = with(density) {
                            it.size.width.toDp()
                        }
                    },
                value = searchQuery,
                onValueChange = { newValue ->
                    searchQuery = newValue
                },
                label = {
                    LabelLarge(
                        text = "Pesquisar nome do local",
                        fontWeight = FontWeight.Normal
                    )
                },
                trailingIcon = {
                    if (addPlaceUiState == AddPlaceUiState.Loading) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(24.dp),
                            color = Colors.ColorTint
                        )
                    } else {
                        Icon(
                            modifier = Modifier
                                .size(24.dp)
                                .clickable {
                                    searchPlaces(searchQuery)
                                },
                            imageVector = EvaIcons.Outline.Search,
                            contentDescription = "Search"
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        searchPlaces(searchQuery)
                    }
                )
            )
        }

        when (addPlaceUiState) {
            is AddPlaceUiState.InitialState -> {}
            is AddPlaceUiState.Loading -> {}
            is AddPlaceUiState.Success -> {
                if (selectedItem != null || addPlaceUiState.places.isNotEmpty()) {
                    VStack(
                        modifier = Modifier
                            .padding(24.dp)
                            .fillMaxWidth(),
                    ) {
                        TitleMedium(text = "Locais encontrados", color = Colors.Black100)
                        Card(
                            modifier = Modifier
                                .padding(top = 6.dp)
                                .clickable {
                                    isDropdownExpanded = !isDropdownExpanded
                                },
                            shape = RoundedCornerShape(4.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFE7ECF7)),
                        ) {
                            HStack(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                LabelLarge(
                                    text = selectedItem?.name?.removeAfterComma()
                                        ?: "Selecione o local",
                                    color = Color(0xFF414D5B)
                                )

                                Icon(
                                    modifier = Modifier
                                        .size(20.dp)
                                        .rotate(if (isDropdownExpanded) 180f else 0f),
                                    tint = Colors.Black100,
                                    imageVector = Icons.Default.ArrowDropDown,
                                    contentDescription = ""
                                )
                            }
                        }
                    }
                }

                DropdownMenu(
                    modifier = Modifier
                        .background(color = Color(0xFFE7ECF7))
                        .width(textFieldWidth + 4.dp),
                    expanded = isDropdownExpanded,
                    onDismissRequest = { isDropdownExpanded = false },
                ) {
                    addPlaceUiState.places.forEachIndexed { placeIndex, place ->
                        DropdownMenuItem(
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Outlined.LocationOn,
                                    contentDescription = ""
                                )
                            },
                            contentPadding = PaddingValues(8.dp),
                            text = {
                                VStack {
                                    LabelLarge(
                                        text = place.name.toString().removeAfterComma(),
                                        color = Color(0xFF414D5B),
                                    )
                                    LabelSmall(
                                        text = place.formattedAddressFindPlace.toString()
                                            .removeAfterComma(),
                                        color = Colors.Gray600,
                                    )
                                }
                            },
                            onClick = {
                                addPlace(place)
                                selectedItem = place
                                isDropdownExpanded = false
                                focusManager.clearFocus()
                            }
                        )
                    }
                }
            }

            is AddPlaceUiState.Error -> {}
            is AddPlaceUiState.IsEmpty -> {}
        }

        if (stepUiState is AddPlaceStepUiState.PlaceSelected) {
            HorizontalDivider()
            VStack(
                modifier = Modifier
                    .padding(24.dp)
            ) {
                TitleLarge(text = "Instagram")

                OutlinedTextField(
                    singleLine = true,
                    textStyle = Typography.labelLarge.copy(fontWeight = FontWeight.Normal),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    value = instagramQuery,
                    onValueChange = { newValue ->
                        instagramQuery = newValue
                    },
                    prefix = {
                        Text(
                            text = "@",
                        )
                    },
                    label = {
                        LabelLarge(
                            text = "Instagram",
                            fontWeight = FontWeight.Normal
                        )
                    }
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = false, backgroundColor = 0xfff)
@Composable
fun AddPlaceScreenPreview() {
    AddPlaceScreen(addPlaceUiState = AddPlaceUiState.InitialState, stepUiState = AddPlaceStepUiState.InitialState, searchPlaces = {
    }, addPlace = {})
}
