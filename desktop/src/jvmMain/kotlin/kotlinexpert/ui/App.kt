package kotlinexpert.ui

import androidx.compose.runtime.*
import kotlinexpert.ui.screens.detail.Detail
import kotlinexpert.ui.screens.detail.DetailViewModel
import kotlinexpert.ui.screens.home.Home
import kotlinexpert.ui.screens.home.HomeViewModel

sealed interface Route {
    object Home : Route
    data class Detail(val id: Long) : Route
}

@Composable
fun App() {

    var route by remember { mutableStateOf<Route>(Route.Home) }
    val scope = rememberCoroutineScope()

    route.let {
        when (it) {
            Route.Home -> Home(
                vm = HomeViewModel(scope),
                onNoteClick = { noteId -> route = Route.Detail(noteId) }
            )

            is Route.Detail -> Detail(
                vm = DetailViewModel(scope, it.id),
                onClose = { route = Route.Home }
            )
        }
    }

}