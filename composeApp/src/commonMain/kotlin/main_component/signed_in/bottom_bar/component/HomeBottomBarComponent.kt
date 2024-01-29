package main_component.signed_in.bottom_bar.component

import com.arkivanov.decompose.ComponentContext

interface HomeBottomBarComponent {

}
class HomeBottomBarComponentImp(
    context: ComponentContext,
): ComponentContext by context, HomeBottomBarComponent {
}