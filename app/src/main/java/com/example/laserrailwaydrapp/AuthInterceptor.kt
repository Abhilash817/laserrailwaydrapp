package com.example.laserrailwaydrapp

import android.content.Context
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response


class AuthInterceptor(
    private val context: Context,
    private val authApi: AuthApi
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        // 1. Add access token
        TokenManager.getAccessToken(context)?.let { token ->
            request = request.newBuilder()
                .addHeader("Authorization", "Bearer $token")
                .build()
        }

        // 2. Proceed with request
        val response = chain.proceed(request)

        // 3. Refresh token if 401
        if (response.code == 401) {
            response.close()
            val newToken = runBlocking { refreshToken() }

            return if (newToken != null) {
                val newRequest = request.newBuilder()
                    .addHeader("Authorization", "Bearer $newToken")
                    .build()
                chain.proceed(newRequest)
            } else {
                TokenManager.clearTokens(context)
                response
            }
        }

        return response
    }

    private suspend fun refreshToken(): String? {
        val refreshToken = TokenManager.getRefreshToken(context) ?: return null
        val response = authApi.refreshToken(RefreshRequest(refreshToken))
        return if (response.isSuccessful) {
            val newAccessToken = response.body()?.accessToken
            if (newAccessToken != null) {
                TokenManager.saveTokens(context, newAccessToken, refreshToken)
            }
            newAccessToken
        } else null
    }
}
