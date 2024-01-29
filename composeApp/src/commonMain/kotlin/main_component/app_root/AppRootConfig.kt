package main_component.app_root

import main_component.signed_in.signed_in_root.SignedInComponent

import kotlinx.serialization.Serializable

@Serializable
sealed class AppRootConfig {
    @Serializable
    data object SignedIn: AppRootConfig()
//    @Serializable
//    data object SignedOut: AppRootConfig()
}

sealed class AppRootChild {
    data class ControllerSignedIn(val component: SignedInComponent): AppRootChild()
//    data class ControllerSignedOut(val component: SignedOutComponent): AppRootChild()
}