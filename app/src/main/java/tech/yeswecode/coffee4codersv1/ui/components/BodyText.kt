package tech.yeswecode.coffee4codersv1.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import tech.yeswecode.coffee4codersv1.ui.theme.Coffee4Codersv1Theme

@Composable
fun BodyText(body: String) {
    Text(body,
        style = MaterialTheme.typography.body2,
        textAlign = TextAlign.Justify)
}

@Preview(
    showBackground = true
)
@Composable
fun BodyTextPreview() {
    Coffee4Codersv1Theme {
        BodyText("Lorem ipsum dolor sit amet consectetur adipiscing elit per, nullam semper nisl aliquet quisque curae vestibulum.. Lorem ipsum dolor sit amet consectetur adipiscing elit per, nullam semper nisl aliquet quisque curae vestibulum.")
    }
}