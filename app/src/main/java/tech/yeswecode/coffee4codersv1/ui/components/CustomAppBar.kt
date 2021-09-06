package tech.yeswecode.coffee4codersv1.ui.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import tech.yeswecode.coffee4codersv1.ui.theme.Purple700

typealias NavigationAction = () -> Unit

@Composable
fun CustomAppBar(title: String? = null, navigationIcon: ImageVector? = null, navigationAction: NavigationAction? = null) {

    val titleText = title ?: ""
    if (navigationIcon != null && navigationAction != null) {
        TopAppBar(
            title = { Text(text = titleText)},
            navigationIcon = {
                IconButton(onClick = { navigationAction() }) {
                    Icon(navigationIcon,"")
                }
            },
            backgroundColor = Purple700
        )
    } else {
        TopAppBar(
            title = { Text(text = titleText)},
            backgroundColor = Purple700
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