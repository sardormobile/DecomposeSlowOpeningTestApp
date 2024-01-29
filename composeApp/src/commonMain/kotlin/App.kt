import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import main_component.app_root.AppRootComponentImpl
import main_component.app_root.AppRootContent

@Composable
internal fun App(context: ComponentContext) {
    MaterialTheme {
        val appRoot = AppRootComponentImpl(context = context)
        AppRootContent(root = appRoot)
    }
}