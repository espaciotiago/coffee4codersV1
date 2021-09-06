package tech.yeswecode.coffee4codersv1.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import tech.yeswecode.coffee4codersv1.ui.theme.Coffee4Codersv1Theme

@Composable
fun DropdownTextField(suggestions: List<String>,
                      value: String,
                      placeholder: String,
                      onValueChange: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var textfieldSize by remember { mutableStateOf(Size.Zero) }
    val icon = Icons.Filled.ArrowDropDown

    Column() {
        CustomTextField(value = value,
            placeholder = placeholder,
            enabled = false,
            trailingIcon = {
                Icon(icon,null,
                    Modifier.clickable { expanded = !expanded })
            },
            onGloballyPositioned = { coordinates ->
                textfieldSize = coordinates.size.toSize()
            },
            onValueChange = onValueChange
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current){textfieldSize.width.toDp()})
        ) {
            suggestions.forEach { label ->
                DropdownMenuItem(onClick = {
                    onValueChange(label)
                }) {
                    Text(text = label, style = MaterialTheme.typography.body2)
                }
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun DropdownTextFieldPreview() {
    val cities = listOf(
        "Ciudad de México, México",
        "La Habana, Cuba",
        "Cancún, México",
        "Medellín, Colombia",
        "Buenos Aires, Argentina",
        "Sao Paulo, Brasil",
        "Lima, Perú",
        "Montevideo, Uruguay",
        "Ciudad de Panamá, Panamá"
    )
    Coffee4Codersv1Theme {
        Box(Modifier.padding(16.dp)){
            DropdownTextField(cities, "", "Ciudad"){}
        }
    }
}