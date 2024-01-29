package main_component.signed_in.bottom_bar.component

import main_component.signed_in.bottom_bar.content.BottomBarScreensConfig
import main_component.signed_in.bottom_bar.content.MainChild
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.backhandler.BackCallback

interface BottomBarRootComponent {
    val childStack: Value<ChildStack<*, MainChild>>
    fun onHomeTabClicked()
    fun onNoteTabClicked()
    fun onImagesTabClicked()
}

class BottomBarRootComponentImpl(
    context: ComponentContext,
) : BottomBarRootComponent, ComponentContext by context {
    private var set = emptySet<BackCallback>()


    private val navigation = StackNavigation<BottomBarScreensConfig>()

    private val stack = childStack(
        source = navigation,
        serializer = BottomBarScreensConfig.serializer(),
        initialConfiguration = BottomBarScreensConfig.Home,
        childFactory = ::createChild,
        key = "BottomBarKey"
    )

    override val childStack: Value<ChildStack<*, MainChild>>
        get() = stack

    override fun onHomeTabClicked() {
        navigation.bringToFront(BottomBarScreensConfig.Home)
    }

    override fun onNoteTabClicked() {
        navigation.bringToFront(BottomBarScreensConfig.Note)
    }

    override fun onImagesTabClicked() {
        navigation.bringToFront(BottomBarScreensConfig.Images)
    }


    private fun createChild(
        config: BottomBarScreensConfig,
        context: ComponentContext,
    ): MainChild = when (config) {

        is BottomBarScreensConfig.Home -> MainChild.HomeScreen(
            HomeBottomBarComponentImp(context = context)
        )

        is BottomBarScreensConfig.Note -> MainChild.NoteScreen(
            NoteBottomBarComponentImpl(context = context)
        )
        is BottomBarScreensConfig.Images -> MainChild.ImagesScreen(
            ImagesBottomBarComponentImpl(context = context)
        )
    }
}