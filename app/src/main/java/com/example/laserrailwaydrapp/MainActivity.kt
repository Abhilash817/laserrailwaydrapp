package com.example.hackathonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import com.example.laserrailwaydrapp.MainApp

import com.example.laserrailwaydrapp.User
import com.example.railwayiqrcodeapp.ui.theme.SignInPage


class
MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                var isAuthenticated by remember { mutableStateOf(false) }
                var user by remember { mutableStateOf<User?>(null) }
                val navController = rememberNavController()

                if (!isAuthenticated) {
                    SignInPage(
                        onSignIn = { userData ->
                            user = userData
                            isAuthenticated = true
                        }
                    )
                } else {
                    MainApp(
                        navController = navController,
                        user = user,
                        onSignOut = {
                            user = null
                            isAuthenticated = false
                        }
                    )
                }
            }
        }
    }




}
