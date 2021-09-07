package tech.yeswecode.coffee4codersv1.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import tech.yeswecode.coffee4codersv1.models.Product
import tech.yeswecode.coffee4codersv1.ui.components.*
import tech.yeswecode.coffee4codersv1.ui.theme.Coffee4Codersv1Theme
import tech.yeswecode.coffee4codersv1.viewModels.CheckoutViewModel
import tech.yeswecode.coffee4codersv1.viewModels.CountryISO
import tech.yeswecode.coffee4codersv1.viewModels.ProductViewModel

@Composable
fun CheckoutScreen(navController: NavController, checkoutVM: CheckoutViewModel) {
    val emptyProduct = Product(0,"","","",0.0,"","COL")
    val product = checkoutVM.productVM.observeAsState(ProductViewModel(product = emptyProduct))
    val loading = checkoutVM.loading.observeAsState(false)

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
        navController.navigate("detail/${product.value.getId()}")
    }

    Scaffold(
        topBar = { CustomAppBar(navigationIcon = Icons.Filled.ArrowBack) {
            onBackPressed()
        } }, content = {
            if(loading.value){
                Loader()
            } else {
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    ProductCard(productVM = product.value) {}

                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {

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
                                Text(
                                    text = "$ 35.0 USD",
                                    style = MaterialTheme.typography.body2,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                            Row {
                                Text(text = "Envio", style = MaterialTheme.typography.caption)
                                Text(
                                    text = "$ 10.0 USD",
                                    style = MaterialTheme.typography.body2,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                        }

                        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                            Text(
                                text = "$ 45.0 USD",
                                style = MaterialTheme.typography.h5,
                                textAlign = TextAlign.Start
                            )
                            CustomButton(label = "Finalizar pedido") {
                                Log.d(
                                    "Finalizar pedido con:",
                                    "$name, $email, $phone, $address, $city"
                                )
                            }
                        }
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
        CheckoutScreen(navController = navController, checkoutVM = CheckoutViewModel(productId = 0))
    }
}