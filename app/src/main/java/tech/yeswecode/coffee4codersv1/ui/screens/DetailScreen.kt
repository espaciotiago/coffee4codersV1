package tech.yeswecode.coffee4codersv1.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import tech.yeswecode.coffee4codersv1.ui.components.BodyText
import tech.yeswecode.coffee4codersv1.ui.components.CountryISO
import tech.yeswecode.coffee4codersv1.ui.components.CustomAppBar
import tech.yeswecode.coffee4codersv1.ui.components.TitleText

@Composable
fun DetailScreen(navController: NavController, country: CountryISO) {

    fun onBackPressed() {
        navController.navigate("feed") {
            popUpTo("feed")
        }
    }

    Scaffold(
        topBar = { CustomAppBar(navigationIcon = Icons.Filled.ArrowBack) {
            onBackPressed()
        } }, content = {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())){
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)) {
                    Image(
                        painter = painterResource(id = country.getBackgroundImage()),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Column(modifier = Modifier.padding(16.dp)) {
                    TitleText(title = "Café de Colombia")
                    Text("Lorem ipsum dolor sit amet consectetur adipiscing elit per, nullam semper nisl aliquet quisque curae.",
                        style = MaterialTheme.typography.caption)
                    Spacer(modifier = Modifier.height(24.dp))
                    BodyText(body = "Lorem ipsum dolor sit amet consectetur adipiscing elit per, nullam semper nisl aliquet quisque curae vestibulum.. Lorem ipsum dolor sit amet consectetur adipiscing elit per, nullam semper nisl aliquet quisque curae vestibulum. Lorem ipsum dolor sit amet consectetur adipiscing elit per, nullam semper nisl aliquet quisque curae vestibulum.. Lorem ipsum dolor sit amet consectetur adipiscing elit per, nullam semper nisl aliquet quisque curae vestibulum.")
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {

                        Text(
                            text = "$ 35.0 USD",
                            style = MaterialTheme.typography.h5,
                            textAlign = TextAlign.End
                        )

                        Button(onClick = {
                        },
                            modifier = Modifier.fillMaxWidth(),
                            shape = MaterialTheme.shapes.large,
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = MaterialTheme.colors.secondary,
                                contentColor = Color.White),
                            elevation = ButtonDefaults.elevation(
                                defaultElevation = 6.dp,
                                pressedElevation = 8.dp,
                                disabledElevation = 0.dp
                            )) {
                            Text(text = "CONTINUAR")
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
fun DetailScreenPreview() {
    val navController = rememberNavController()
    DetailScreen(navController = navController, country = CountryISO.COL)
}