package main_component.app_root

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import main_component.signed_in.signed_in_root.SignedInContent

@Composable
fun AppRootContent(root: AppRootComponent) {

    val childStack by root.childStack.subscribeAsState()
    Children(
        stack = childStack,
        animation = stackAnimation(fade().plus(scale()))
    ) { child ->
        when (val instance = child.instance) {
            is AppRootChild.ControllerSignedIn -> SignedInContent(component = instance.component)
//            is AppRootChild.ControllerSignedOut -> SignedOutContent(component = instance.component)
        }
    }

}