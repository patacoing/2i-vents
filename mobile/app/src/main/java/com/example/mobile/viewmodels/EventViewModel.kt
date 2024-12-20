package com.example.mobile.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile.repositories.EventsRepository
import com.example.mobile.services.EventDetailResponse
import com.example.mobile.services.EventResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val eventsRepository: EventsRepository
) : ViewModel() {

    var eventsList by mutableStateOf<List<EventResponse>>(emptyList())
        private set
    var selectedEvent by mutableStateOf<EventDetailResponse?>(null)
        private set
    var isLoading by mutableStateOf(false)
        private set

    fun loadEvents() {
        viewModelScope.launch {
            isLoading = true
            try {
                eventsList = eventsRepository.getEvents()
            } catch (e: Exception) {
                // Gérer l'erreur
            } finally {
                isLoading = false
            }
        }
    }

    fun loadEventDetail(id: String) {
        viewModelScope.launch {
            isLoading = true
            try {
                selectedEvent = eventsRepository.getEventDetail(id)
            } catch (e: Exception) {
                // Gérer l'erreur
            } finally {
                isLoading = false
            }
        }
    }
}
