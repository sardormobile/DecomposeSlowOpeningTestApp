package main_component.signed_in.signed_in_root

import main_component.signed_in.bottom_bar.component.BottomBarRootComponentImpl
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value

interface SignedInComponent {
    val childStack: Value<ChildStack<*, SignedInChild>>
}

class SignedInComponentImpl(
    context: ComponentContext
) : ComponentContext by context, SignedInComponent {

    private val navigation = StackNavigation<SignedInScreensConfig>()

    override val childStack: Value<ChildStack<*, SignedInChild>> = childStack(
        source = navigation,
        serializer = SignedInScreensConfig.serializer(),
        initialConfiguration = SignedInScreensConfig.Main,
        handleBackButton = true,
        key = "AppRootComponentImplKey",
        childFactory = ::child,
    )

    @OptIn(ExperimentalDecomposeApi::class)
    private fun child(
        config: SignedInScreensConfig,
        context: ComponentContext,
    ): SignedInChild = when (config) {
        is SignedInScreensConfig.Main -> SignedInChild.ScreenMain(BottomBarRootComponentImpl(context = context))
    }
}