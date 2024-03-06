package br.com.cvj.discovr.ui.screen.addplace

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
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
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
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

    AddPlaceScreen(addPlaceUiState = addPlaceUiState, searchPlaces = viewModel::searchPlaces)
}

@Composable
fun AddPlaceScreen(
    addPlaceUiState: AddPlaceUiState,
    modifier: Modifier = Modifier,
    searchPlaces: (name: String) -> Unit,
//    uiState: AddPlaceUiState,
) {
    var searchQuery by remember { mutableStateOf("") }
//    var searchResults by remember { mutableStateOf(listOf<String>()) }
    var selectedItem by remember { mutableStateOf<GooglePlaces.Place?>(null) }
    var isDropdownExpanded by remember { mutableStateOf(false) }
    var textFieldWidth by remember { mutableStateOf(0.dp) }

    VStack(
        modifier = Modifier
            .safeContentPadding()
            .padding(16.dp)
    ) {
        HStack {
            OutlinedTextField(
                textStyle = Typography.labelLarge.copy(fontWeight = FontWeight.Normal),
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        textFieldWidth = coordinates.size.width.dp
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
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
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
                                text = selectedItem?.name?.removeAfterComma() ?: "Selecione o local",
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

                DropdownMenu(
                    modifier = Modifier
                        .width(LocalConfiguration.current.screenWidthDp.dp - 32.dp)
                        .background(color = Color(0xFFE7ECF7)),
                    expanded = isDropdownExpanded,
                    onDismissRequest = { isDropdownExpanded = false },
                ) {
                    addPlaceUiState.places.forEachIndexed { placeIndex, place ->
                        DropdownMenuItem(
                            leadingIcon = {
                                Icon(imageVector = Icons.Outlined.LocationOn, contentDescription = "")
                            },
                            contentPadding = PaddingValues(8.dp),
                            text = {
                                VStack {
                                    LabelLarge(
                                        text = place.name.toString().removeAfterComma(),
                                        color = Color(0xFF414D5B),
                                    )
                                    LabelSmall(
                                        text = place.formattedAddressFindPlace.toString().removeAfterComma(),
                                        color = Colors.Gray600,
                                    )
                                }
                            },
                            onClick = {
                                selectedItem = place
                                isDropdownExpanded = false
                            }
                        )
                    }
                }
            }

            is AddPlaceUiState.Error -> {}
            is AddPlaceUiState.IsEmpty -> {}
        }
    }
}

@Preview(showSystemUi = true, showBackground = false, backgroundColor = 0xfff)
@Composable
fun AddPlaceScreenPreview() {
    AddPlaceScreen(addPlaceUiState = AddPlaceUiState.InitialState, searchPlaces = {})
}
