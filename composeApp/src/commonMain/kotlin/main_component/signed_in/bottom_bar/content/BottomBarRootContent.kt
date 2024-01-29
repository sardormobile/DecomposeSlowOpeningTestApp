package main_component.signed_in.bottom_bar.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import main_component.screens.HomeScreen
import main_component.screens.ImagesScreen
import main_component.screens.NotesScreen
import main_component.signed_in.bottom_bar.component.BottomBarRootComponent

@Composable
fun BottomBarContent(component: BottomBarRootComponent, modifier: Modifier = Modifier) {
    val bottomBarColor = Color(0xFF292C31)
    val bottomBarHeight = 68.dp //+ bottomNavBarBottomPadding//68.dp

    Scaffold(
        modifier = modifier,
        bottomBar = {
            Column {
                BottomAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(horizontal = 0.dp),
                    cutoutShape = CircleShape,
                    backgroundColor = bottomBarColor,
                    elevation = 22.dp,
                ) {

                    BottomBarInit(component = component, bottomBarHeight = bottomBarHeight, modifier = Modifier.fillMaxWidth())
                }
                Spacer(
                    Modifier.fillMaxWidth().windowInsetsBottomHeight(WindowInsets.systemBars).background(bottomBarColor)
                )
            }

        },
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            ChildrenInit(component = component, modifier = Modifier.fillMaxSize())
        }
    }
}

@Composable
private fun ChildrenInit(component: BottomBarRootComponent, modifier: Modifier = Modifier) {

    Children(
        stack = component.childStack,
        modifier = modifier,
        animation = stackAnimation(fade())
    ) {
        when (val child = it.instance) {
            is MainChild.HomeScreen -> HomeScreen()
            is MainChild.NoteScreen -> NotesScreen()
            is MainChild.ImagesScreen -> ImagesScreen()
        }
    }
}

@Composable
private fun BottomBarInit(component: BottomBarRootComponent, bottomBarHeight: Dp, modifier: Modifier = Modifier) {
    val childStack by component.childStack.subscribeAsState()
    val activeComponent = childStack.active.instance
    BottomNavigation(
        modifier = modifier
            .fillMaxWidth()
            .height(bottomBarHeight),//74
        backgroundColor = Color.Transparent,
        contentColor = Color.White,
        elevation = 0.dp
    ) {
        BottomNavigationItem(
            alwaysShowLabel = false,
            selected = activeComponent is MainChild.HomeScreen,
            unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
            onClick = component::onHomeTabClicked,
            icon = {
                Icon(
                    modifier = Modifier.size(32.dp),//34.dp
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"
                )
            },
        )
        BottomNavigationItem(
            alwaysShowLabel = false,
            selected = activeComponent is MainChild.NoteScreen,
            unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
            onClick = component::onNoteTabClicked,
            icon = {
                Icon(
                    modifier = Modifier.size(32.dp),
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Notes"
                )
            },
        )
        BottomNavigationItem(
            alwaysShowLabel = false,
            selected = activeComponent is MainChild.NoteScreen,
            unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
            onClick = component::onImagesTabClicked,
            icon = {
                Icon(
                    modifier = Modifier.size(32.dp),
                    imageVector = Icons.Default.Face,
                    contentDescription = "Images"
                )
            },
        )
    }
}