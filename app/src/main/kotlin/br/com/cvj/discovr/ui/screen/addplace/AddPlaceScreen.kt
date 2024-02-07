package br.com.cvj.discovr.ui.screen.addplace

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import br.com.cvj.discovr.ui.util.components.stack.HStack
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
    var searchQuery by remember { mutableStateOf("") }
    var searchResults by remember { mutableStateOf(listOf<String>()) }
    var selectedItem by remember { mutableStateOf<String?>(null) }

    HStack(modifier = Modifier.safeContentPadding()) {
        TextField(
            value = searchQuery,
            onValueChange = { newValue ->
                searchQuery = newValue
            },
            label = { Text("Search") }
        )

        Button(onClick = { searchResults = performSearch(searchQuery) }) {
            Text("Search")
        }

        if (searchResults.isNotEmpty()) {
            Dialog(onDismissRequest = { searchResults = listOf() }) {
                LazyColumn {
                    items(searchResults) { result ->
                        Text(
                            text = result,
                            modifier = Modifier.clickable {
                                selectedItem = result
                                searchResults = listOf()
                            }
                        )
                    }
                }
            }
        }

        selectedItem?.let { Text("Selected item: $it") }
    }
}

fun performSearch(query: String): List<String> {
    // Replace this with your actual search logic
    return listOf("Result 1", "Result 2", "Result 3")
}

@Preview(showSystemUi = true, showBackground = false, backgroundColor = 0xfff)
@Composable
fun AddPlaceScreenPreview() {
    AddPlaceScreen()
}
