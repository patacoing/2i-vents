package com.example.mobile.models

data class User(
    val id: String? = null,
    val firstName: String,
    val lastName: String,
    val password: String,
    val promo: String,
    val role: String
)

data class AuthLoginBody(
    val firstname: String,
    val lastname: String,
    val password: String
)

data class AuthRegisterBody(
    val firstName: String,
    val lastName: String,
    val promo: String,
    val password: String
)

data class AuthResponse(
    val accessToken: String,
    val refreshToken: String,
    val iduser: String
)
