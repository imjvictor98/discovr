package br.com.cvj.discovr.ui.util

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.cvj.discovr.navigation.NavGraphs
import br.com.cvj.discovr.navigation.appCurrentDestinationAsState
import br.com.cvj.discovr.navigation.appDestination
import br.com.cvj.discovr.navigation.destinations.Destination
import br.com.cvj.discovr.navigation.startAppDestination
import br.com.cvj.discovr.util.SnackbarController
import br.com.cvj.discovr.util.network.NetworkMonitor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@Composable
fun rememberAppState(
    networkMonitor: NetworkMonitor,
    navController: NavHostController = rememberNavController(),
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
): AppState {
    return remember(navController, snackbarHostState, coroutineScope, networkMonitor) {
        AppState(navController, snackbarHostState, coroutineScope, networkMonitor)
    }
}

// Controls app state. Stable -> if any of the values is changed, the Composables are recomposed
@Stable
class AppState(
    val navController: NavHostController,
    val snackbarHostState: SnackbarHostState,
    coroutineScope: CoroutineScope,
    networkMonitor: NetworkMonitor,
    val snackbarController: SnackbarController = SnackbarController(
        snackbarHostState,
        coroutineScope
    )
) {
    /**
     * App's current [Destination] if set, otherwise starting destination.
     *
     * Starting destination: search for `@RootNavGraph(start = true)`
     */
    val currentDestination: Destination
        @Composable get() = navController.appCurrentDestinationAsState().value
            ?: NavGraphs.root.startAppDestination

    /**
     * App's previous destination if set, otherwise null
     */
    val prevDestination: Destination?
        @Composable get() = navController.previousBackStackEntry?.appDestination()

    /**
     * Manages app connectivity status
     */
    val isOffline = networkMonitor.isOnline
        .map(Boolean::not)
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = false
        )

    fun goBack() {
        navController.navigateUp()
    }
}
