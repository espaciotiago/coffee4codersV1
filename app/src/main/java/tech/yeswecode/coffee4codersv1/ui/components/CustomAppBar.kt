package tech.yeswecode.coffee4codersv1.ui.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

typealias NavigationAction = () -> Unit

@Composable
fun CustomAppBar(title: String? = null, navigationIcon: ImageVector? = null, navigationAction: NavigationAction? = null) {

    val titleText = title ?: "Coffe4Coders"
    if (navigationIcon != null && navigationAction != null) {
        TopAppBar(
            title = { Text(text = titleText)},
            navigationIcon = {
                IconButton(onClick = { navigationAction() }) {
                    Icon(navigationIcon,"")
                }
            },
            backgroundColor = MaterialTheme.colors.primary
        )
    } else {
        TopAppBar(
            title = { Text(text = titleText)},
            backgroundColor = MaterialTheme.colors.primary
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun CustomAppBarPreview() {
    CustomAppBar()
}