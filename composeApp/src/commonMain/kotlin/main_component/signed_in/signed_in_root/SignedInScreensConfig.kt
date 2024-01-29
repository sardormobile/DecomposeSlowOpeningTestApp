package main_component.signed_in.signed_in_root

import kotlinx.serialization.Serializable
import main_component.signed_in.bottom_bar.component.BottomBarRootComponent

@Serializable
sealed class SignedInScreensConfig {
    @Serializable
    data object Main : SignedInScreensConfig()
}
sealed class SignedInChild {
    data class ScreenMain(val component: BottomBarRootComponent) : SignedInChild()//MainChild
    //TODO:Other screens
}