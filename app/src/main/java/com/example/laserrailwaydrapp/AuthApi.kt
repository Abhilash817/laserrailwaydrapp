package com.example.laserrailwaydrapp



import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

// --- Data classes ---
data class LoginRequest(val email: String, val password: String)
data class LoginResponse(val accessToken: String, val refreshToken: String)
data class RefreshRequest(val refreshToken: String)

// --- API interface ---
interface AuthApi {
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST("auth/refresh")
    suspend fun refreshToken(@Body request: RefreshRequest): Response<LoginResponse>
}
