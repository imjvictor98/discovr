package br.com.cvj.discovr.ui.util.components.button.fab

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ButtonFab(icon: ImageVector, modifier: Modifier = Modifier, onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick, modifier = modifier) {
        Icon(imageVector = icon, contentDescription = null)
    }
}

@Composable
fun ButtonFabExtend(
    text: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    ExtendedFloatingActionButton(
        text = { Text(text) },
        icon = { Icon(imageVector = icon, contentDescription = null) },
        onClick = onClick,
        modifier = modifier
    )
}

@Preview
@Composable
fun ButtonFabPreview() {
    ButtonFab(icon = Icons.Default.Add, onClick = {})
}

@Preview
@Composable
fun ButtonFabExtendPreview() {
    ButtonFabExtend(text = "Extended FAB", icon = Icons.Default.Add, onClick = {})
}
