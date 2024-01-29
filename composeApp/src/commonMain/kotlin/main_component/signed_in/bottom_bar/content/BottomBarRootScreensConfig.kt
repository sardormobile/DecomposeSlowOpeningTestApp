package main_component.signed_in.bottom_bar.content

import main_component.signed_in.bottom_bar.component.HomeBottomBarComponent
import main_component.signed_in.bottom_bar.component.NoteBottomBarComponent
import kotlinx.serialization.Serializable
import main_component.signed_in.bottom_bar.component.ImagesBottomBarComponent

@Serializable
sealed class BottomBarScreensConfig {
    @Serializable
    data object Home: BottomBarScreensConfig()
    @Serializable
    data object Note: BottomBarScreensConfig()
    @Serializable
    data object Images: BottomBarScreensConfig()
}
sealed class MainChild {
    data class HomeScreen(val component: HomeBottomBarComponent): MainChild()
    data class NoteScreen(val component: NoteBottomBarComponent): MainChild()
    data class ImagesScreen(val component: ImagesBottomBarComponent): MainChild()
}