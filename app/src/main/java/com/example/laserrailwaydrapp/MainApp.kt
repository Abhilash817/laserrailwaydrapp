package com.example.laserrailwaydrapp
import android.annotation.SuppressLint
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainApp(
    navController: NavHostController,
    user: User?,
    onSignOut: () -> Unit
) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) } // like your <BottomNavigation />
    ) {  innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "dashboard"
        ) {
            composable("dashboard") {
                DashboardScreen(user, onSignOut)
            }
            composable("qr-generator") {
                QRGeneratorScreen(user)
            }
            composable("qr-scanner") {
                QRScannerScreen(user)
            }
            composable("reports") {
                ReportsScreen(user)
            }
            composable("profile") {
                UserProfileScreen(user, onSignOut)
            }
        }
    }
}
