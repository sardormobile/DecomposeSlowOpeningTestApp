package main_component.signed_in.bottom_bar.component

import com.arkivanov.decompose.ComponentContext

interface ImagesBottomBarComponent {
}
class ImagesBottomBarComponentImpl (
    context: ComponentContext
): ComponentContext by context, ImagesBottomBarComponent {
}