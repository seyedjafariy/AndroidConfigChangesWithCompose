package com.worldsnas.samplecompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.worldsnas.samplecompose.ui.theme.SampleComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val controller = rememberNavController()
                    NavHost(navController = controller, startDestination = "login") {
                        composable("login") {
                            Login {
                                controller.navigate("greetings")
                            }
                        }

                        composable("greetings") {
                            GreetingScreen()
                        }
                    }
                }
            }
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }
}


@Composable
fun Login(logedIn: () -> Unit) {
    Column {
        Text(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterHorizontally)
                .clickable {
                    logedIn()
                },
            text = "Login",
            fontSize = 20.sp
        )
    }
}

@Composable
fun GreetingScreen() {
    val counter = remember { mutableStateOf(1) }

    Column(Modifier.fillMaxSize()) {
        Greeting(
            Modifier
                .fillMaxSize()
                .align(Alignment.CenterHorizontally)
                .clickable { counter.value++ },
            "current count= ${counter.value}"
        )
    }
}


@Composable
fun Greeting(modifier: Modifier, name: String) {
    Text(
        modifier = modifier,
        text = "${stringResource(R.string.greetings)} $name!",
        textAlign = TextAlign.Center,
        fontSize = 20.sp
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SampleComposeTheme {
        Greeting(Modifier, "Android")
    }
}