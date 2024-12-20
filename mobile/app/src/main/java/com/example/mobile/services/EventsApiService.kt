package com.example.mobile.services

import com.example.mobile.models.Event
import com.example.mobile.models.NewEvent
import com.example.mobile.models.Organizer
import com.example.mobile.models.Participant
import com.example.mobile.models.UpdateEvent
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

class SignUpRequest(email: String, password: String)

class SignUpResponse

class LoginRequest(email: String, password: String)

class LoginResponse

class EventResponse

class EventDetailResponse

interface EventsApiService {
    @GET("events")
    suspend fun getAllEvents(): List<Event>

    @POST("events")
    suspend fun createEvent(@Body newEvent: NewEvent): Event

    @GET("events/{eventId}")
    suspend fun getEventById(@Path("eventId") eventId: String): Event

    @PUT("events/{eventId}")
    suspend fun updateEvent(@Path("eventId") eventId: String, @Body updatedEvent: UpdateEvent): Event

    @DELETE("events/{eventId}")
    suspend fun deleteEvent(@Path("eventId") eventId: String): Response<Unit>

    @POST("events/{eventId}/participants")
    suspend fun addParticipant(@Path("eventId") eventId: String, @Body participant: Participant): Response<Unit>

    @DELETE("events/{eventId}/participants/{userId}")
    suspend fun deleteParticipant(@Path("eventId") eventId: String, @Path("userId") userId: String): Response<Unit>

    @POST("events/{eventId}/organizers")
    suspend fun addOrganizer(@Path("eventId") eventId: String, @Body organizer: Organizer): Response<Unit>

    @DELETE("events/{eventId}/organizers/{userId}")
    suspend fun deleteOrganizer(@Path("eventId") eventId: String, @Path("userId") userId: String): Response<Unit>
}
