package tech.yeswecode.coffee4codersv1.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import tech.yeswecode.coffee4codersv1.ui.components.*
import tech.yeswecode.coffee4codersv1.ui.theme.Coffee4Codersv1Theme

@Composable
fun CheckoutScreen(navController: NavController, country: CountryISO) {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
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

    fun onBackPressed() {
        navController.navigate("detail/${country.iso}")
    }

    Scaffold(
        topBar = { CustomAppBar(navigationIcon = Icons.Filled.ArrowBack) {
            onBackPressed()
        } }, content = {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                ProductCard(
                    name = "Café de Colombia",
                    summary = "Café de origen de las montañas colombianas.",
                    price = 35.0,
                    currency = "USD",
                    country = CountryISO.COL
                ) {}

                Column(modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)) {

                    CustomTextField(name, "Nombre del comprador") {
                        name = it
                    }
                    CustomTextField(email, "Correo electrónico") {
                        email = it
                    }
                    CustomTextField(phone, "Número telefónico") {
                        phone = it
                    }
                    CustomTextField(address, "Dirección") {
                        address = it
                    }
                    DropdownTextField(cities, city, "Ciudad") {
                        city = it
                    }

                    Column {
                        Row {
                            Text(text = "Subtotal", style = MaterialTheme.typography.caption)
                            Text(text = "$ 35.0 USD",
                                style = MaterialTheme.typography.body2,
                                textAlign = TextAlign.End,
                                modifier = Modifier.fillMaxWidth())
                        }
                        Row {
                            Text(text = "Envio", style = MaterialTheme.typography.caption)
                            Text(text = "$ 10.0 USD",
                                style = MaterialTheme.typography.body2,
                                textAlign = TextAlign.End,
                                modifier = Modifier.fillMaxWidth())
                        }
                    }

                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        Text(
                            text = "$ 45.0 USD",
                            style = MaterialTheme.typography.h5,
                            textAlign = TextAlign.Start
                        )
                        CustomButton(label = "Finalizar pedido") {}
                    }
                }
            }
        })
}

@Preview(
    showBackground = true
)
@Composable
private fun CheckoutScreenPreview() {
    val navController = rememberNavController()
    Coffee4Codersv1Theme {
        CheckoutScreen(navController = navController, country = CountryISO.COL)
    }
}