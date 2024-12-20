package com.example.mobile.repositories

import com.example.mobile.models.AuthLoginBody
import com.example.mobile.models.AuthRegisterBody
import com.example.mobile.models.AuthResponse
import com.example.mobile.models.User
import com.example.mobile.services.UserApiService
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val userApi: UserApiService
) {
    suspend fun login(firstname: String, lastname: String, password: String): AuthResponse {
        return userApi.login(AuthLoginBody(firstname, lastname, password))
    }

    suspend fun register(firstname: String, lastname: String, promotion: String, password: String): User {
        return userApi.register(AuthRegisterBody(firstname, lastname, promotion, password))
    }
}