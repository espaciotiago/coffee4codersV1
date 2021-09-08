package tech.yeswecode.coffee4codersv1.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tech.yeswecode.coffee4codersv1.ui.theme.Coffee4Codersv1Theme

typealias RefreshAcion = () -> Unit

@Composable
fun EmptyView(refreshAcion: RefreshAcion) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)) {
        Text(text = "No hay datos para mostrar", style = MaterialTheme.typography.body2, modifier = Modifier.padding(bottom = 16.dp))
        CustomButton(label = "Refrescar") {
            refreshAcion()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EmptyViewPreview() {
    Coffee4Codersv1Theme {
        EmptyView {}
    }
}