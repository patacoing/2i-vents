package com.example.mobile.repositories

import com.example.mobile.models.Event
import com.example.mobile.models.NewEvent
import com.example.mobile.models.Organizer
import com.example.mobile.models.Participant
import com.example.mobile.models.UpdateEvent
import com.example.mobile.services.EventsApiService
import javax.inject.Inject

class EventsRepository @Inject constructor(
    private val api: EventsApiService
) {
    suspend fun getEvents(): List<Event> {
        return api.getAllEvents()
    }

    suspend fun getEventDetail(id: String): Event {
        return api.getEventById(id)
    }

    suspend fun createEvent(newEvent: NewEvent): Event {
        return api.createEvent(newEvent)
    }

    suspend fun updateEvent(eventId: String, updateEvent: UpdateEvent): Event {
        return api.updateEvent(eventId, updateEvent)
    }

    suspend fun deleteEvent(eventId: String) {
        api.deleteEvent(eventId)
    }

    suspend fun addParticipant(eventId: String, userId: Int) {
        api.addParticipant(eventId, Participant(userId))
    }

    suspend fun deleteParticipant(eventId: String, userId: String) {
        api.deleteParticipant(eventId, userId)
    }

    suspend fun addOrganizer(eventId: String, userId: Int) {
        api.addOrganizer(eventId, Organizer(userId))
    }

    suspend fun deleteOrganizer(eventId: String, userId: String) {
        api.deleteOrganizer(eventId, userId)
    }
}
