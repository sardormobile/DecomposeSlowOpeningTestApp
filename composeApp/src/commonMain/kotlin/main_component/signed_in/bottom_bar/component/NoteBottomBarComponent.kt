package main_component.signed_in.bottom_bar.component

import com.arkivanov.decompose.ComponentContext

interface NoteBottomBarComponent {
}
class NoteBottomBarComponentImpl (
    context: ComponentContext
): ComponentContext by context, NoteBottomBarComponent {
}