package com.example.mobile.services

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

class SignUpRequest(email: String, password: String)

class SignUpResponse

class LoginRequest(email: String, password: String)

class LoginResponse

class EventResponse

class EventDetailResponse

interface ApiService {
    @POST("signup")
    suspend fun signUp(@Body user: SignUpRequest): SignUpResponse

    @POST("login")
    suspend fun login(@Body creds: LoginRequest): LoginResponse

    @GET("events")
    suspend fun getEvents(): List<EventResponse>

    @GET("events/{id}")
    suspend fun getEventDetail(@Path("id") id: String): EventDetailResponse

}