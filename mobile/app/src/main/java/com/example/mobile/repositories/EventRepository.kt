package com.example.mobile.repositories

import com.example.mobile.services.ApiService
import com.example.mobile.services.EventDetailResponse
import com.example.mobile.services.EventResponse
import javax.inject.Inject

class EventsRepository @Inject constructor(
    private val api: ApiService
) {
    suspend fun getEvents(): List<EventResponse> {
        return api.getEvents()
    }

    suspend fun getEventDetail(id: String): EventDetailResponse {
        return api.getEventDetail(id)
    }
}