package com.example.laserrailwaydrapp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar {
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("dashboard") },
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
            label = { Text("Dashboard") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("qr-generator") },
            icon = { Icon(Icons.Filled.Add, contentDescription = "QR Generator") },
            label = { Text("Generate") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("qr-scanner") },
            icon = { Icon(Icons.Filled.Add, contentDescription = "QR Scanner") },
            label = { Text("Scan") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("reports") },
            icon = { Icon(Icons.AutoMirrored.Filled.List, contentDescription = "Reports") },
            label = { Text("Reports") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("profile") },
            icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
            label = { Text("Profile") }
        )
    }
}
