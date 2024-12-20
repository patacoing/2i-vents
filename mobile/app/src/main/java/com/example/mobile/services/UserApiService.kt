package com.example.mobile.services

import com.example.mobile.models.AuthLoginBody
import com.example.mobile.models.AuthRegisterBody
import com.example.mobile.models.AuthResponse
import com.example.mobile.models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserApiService {

    // Utilisateurs
    @GET("users")
    suspend fun getAllUsers(): List<User>

    @GET("users/{id}")
    suspend fun getUserById(@Path("id") id: String): User

    @PUT("users/{id}")
    suspend fun updateUser(@Path("id") id: String, @Body user: User): User

    @DELETE("users/{id}")
    suspend fun deleteUser(@Path("id") id: String): Response<Unit>

    // Authentification
    @POST("auth/login")
    suspend fun login(@Body loginBody: AuthLoginBody): AuthResponse

    @POST("auth/register")
    suspend fun register(@Body registerBody: AuthRegisterBody): User
}
