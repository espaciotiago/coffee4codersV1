package tech.yeswecode.coffee4codersv1.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import tech.yeswecode.coffee4codersv1.models.Product
import tech.yeswecode.coffee4codersv1.ui.components.*
import tech.yeswecode.coffee4codersv1.ui.theme.Coffee4Codersv1Theme
import tech.yeswecode.coffee4codersv1.viewModels.CheckoutViewModel
import tech.yeswecode.coffee4codersv1.viewModels.ProductViewModel

@Composable
fun CheckoutScreen(navController: NavController, checkoutVM: CheckoutViewModel) {
    val emptyProduct = Product(0,"","","",0.0,"","COL")
    val product = checkoutVM.productVM.observeAsState(ProductViewModel(product = emptyProduct))
    val cities = checkoutVM.cities.observeAsState(ArrayList())
    val loading = checkoutVM.loading.observeAsState(false)
    val name = checkoutVM.name.observeAsState("")
    val email = checkoutVM.email.observeAsState("")
    val phone = checkoutVM.phone.observeAsState("")
    val city = checkoutVM.city.observeAsState("")
    val address = checkoutVM.address.observeAsState("")
    val errorMessage = checkoutVM.errorMessage.observeAsState(null)
    val successMessage = checkoutVM.successMessage.observeAsState(null)
    val shippingFee = 10.0

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
                Alert(title= "Ups", message = errorMessage.value) {
                    checkoutVM.removeError()
                }
                Alert(title= "??Felicidades!", message = successMessage.value) {
                    checkoutVM.removeError()
                    navController.navigate("feed") {
                        launchSingleTop = true
                        popUpTo("feed")
                    }
                }
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    ProductCard(productVM = product.value) {}

                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {

                        CustomTextField(name.value, "Nombre del comprador") {
                            checkoutVM.setName(it)
                        }
                        CustomTextField(email.value, "Correo electr??nico") {
                            checkoutVM.setEmail(it)
                        }
                        CustomTextField(phone.value, "N??mero telef??nico") {
                            checkoutVM.setPhone(it)
                        }
                        CustomTextField(address.value, "Direcci??n") {
                            checkoutVM.setAddress(it)
                        }
                        DropdownTextField(cities.value, city.value, "Ciudad") {
                            checkoutVM.setCity(it)
                        }

                        Column {
                            Row {
                                Text(text = "Subtotal", style = MaterialTheme.typography.caption)
                                Text(
                                    text = "$ ${product.value.getPrice()} ${product.value.getCurrency()}",
                                    style = MaterialTheme.typography.body2,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                            Row {
                                Text(text = "Envio", style = MaterialTheme.typography.caption)
                                Text(
                                    text = "$ $shippingFee USD",
                                    style = MaterialTheme.typography.body2,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                        }

                        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                            Text(
                                text = "$ ${product.value.getPrice() + shippingFee} ${product.value.getCurrency()}",
                                style = MaterialTheme.typography.h5,
                                textAlign = TextAlign.Start
                            )
                            CustomButton(label = "Finalizar pedido") {
                                checkoutVM.completePurchase()
                            }
                        }
                    }
                }
            }
        })
}

@Composable
fun Alert(title: String = "", message: String?, onClose: () -> Unit) {
    if(message != null) {
        AlertDialog(
            onDismissRequest = { onClose() },
            title = { Text(text = title, style = TextStyle(color = Color.Black)) },
            text = { Text(text = message) },
            confirmButton = {
                Button(
                    onClick = {
                        onClose()
                    }) {
                    Text("Ok")
                }
            },
        )
    }
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