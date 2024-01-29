package main_component.app_root

import main_component.signed_in.signed_in_root.SignedInComponentImpl
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value

interface AppRootComponent {
    val childStack: Value<ChildStack<*, AppRootChild>>
}

class AppRootComponentImpl(
    context: ComponentContext
) : ComponentContext by context, AppRootComponent {

    private val navigation = StackNavigation<AppRootConfig>()

    override val childStack: Value<ChildStack<*, AppRootChild>> =
        childStack(
            source = navigation,
            serializer = AppRootConfig.serializer(),
            initialConfiguration = AppRootConfig.SignedIn,
            handleBackButton = false,
            key = "AppRootComponentImplKey",
            childFactory = ::child,
        )

    private fun child(
        config: AppRootConfig,
        context: ComponentContext,
    ): AppRootChild = when (config) {
//        is AppRootConfig.SignedOut -> {
//            AppRootChild.ControllerSignedOut()
//        }
        is AppRootConfig.SignedIn -> {
            AppRootChild.ControllerSignedIn(component = SignedInComponentImpl(context = context))
        }
    }
}