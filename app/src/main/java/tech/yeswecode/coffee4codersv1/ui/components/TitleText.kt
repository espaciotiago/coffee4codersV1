package tech.yeswecode.coffee4codersv1.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import tech.yeswecode.coffee4codersv1.ui.theme.Coffee4Codersv1Theme

@Composable
fun TitleText(title: String){
    Text(title,
        style = MaterialTheme.typography.h3)
}

@Preview(
    showBackground = true
)
@Composable
fun TitleTextPreview() {
    Coffee4Codersv1Theme {
        TitleText("Titulo")
    }
}