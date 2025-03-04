package com.example.almacenmpy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "inicio") {
        composable("inicio") { InicioScreen(navController) }
        composable("stock") { StockScreen() }
    }
}

@Composable
fun InicioScreen(navController: NavController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Pantalla de Inicio") }) }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { navController.navigate("stock") },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Entrar")
            }
        }
    }
}

@Composable
fun StockScreen() {
    var stock by remember { mutableStateOf(10) } // Stock inicial

    Scaffold(
        topBar = { TopAppBar(title = { Text("Gestión de Stock") }) }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text("Producto: Laptop", style = MaterialTheme.typography.h5, modifier = Modifier.padding(16.dp))
            Text("Stock: $stock", style = MaterialTheme.typography.h6, modifier = Modifier.padding(16.dp))

            Row(modifier = Modifier.padding(16.dp)) {
                Button(onClick = { if (stock > 0) stock-- }) {
                    Text("-")
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(onClick = { stock++ }) {
                    Text("+")
                }
            }
        }
    }
}