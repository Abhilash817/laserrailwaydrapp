package com.example.laserrailwaydrapp
//
//
//
//import android.content.Context
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//
//class AuthViewModelFactory(
//    private val authApi: AuthApi,
//    private val context: Context
//) : ViewModelProvider.Factory {
//
//    @Suppress("UNCHECKED_CAST")
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
//            return AuthViewModel(authApi, appplication) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}
