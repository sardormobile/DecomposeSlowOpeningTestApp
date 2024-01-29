package main_component.signed_in.signed_in_root

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import main_component.signed_in.bottom_bar.content.BottomBarContent

@Composable
fun SignedInContent(component: SignedInComponent, modifier: Modifier = Modifier) {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {

                val childStack by component.childStack.subscribeAsState()
                Children(
                    stack = childStack,
                    animation = stackAnimation(scale().plus(fade()))
                ) { child ->
                    when (val instance = child.instance) {
                        is SignedInChild.ScreenMain -> BottomBarContent(
                            component = instance.component,
                            modifier = modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
}
