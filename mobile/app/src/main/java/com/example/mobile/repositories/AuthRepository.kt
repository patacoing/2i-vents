package com.example.mobile.repositories

import com.example.mobile.services.ApiService
import com.example.mobile.services.LoginRequest
import com.example.mobile.services.LoginResponse
import com.example.mobile.services.SignUpRequest
import com.example.mobile.services.SignUpResponse
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val api: ApiService
) {
    suspend fun signUp(user: SignUpRequest): SignUpResponse {
        return api.signUp(user)
    }

    suspend fun login(creds: LoginRequest): LoginResponse {
        return api.login(creds)
    }
}