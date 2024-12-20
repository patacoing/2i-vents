package com.example.mobile.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mobile.models.Event
import com.example.mobile.models.NewEvent
import com.example.mobile.models.User
import com.example.mobile.repositories.EventsRepository
import com.example.mobile.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class EventsViewModel @Inject constructor(
    private val eventsRepository: EventsRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    var eventsList by mutableStateOf<List<Event>>(emptyList())
        private set
    var selectedEvent by mutableStateOf<Event?>(null)
        private set
    var isLoading by mutableStateOf(false)
        private set
    var errorMessage by mutableStateOf<String?>(null)
        private set
    var participants by mutableStateOf<List<User>>(emptyList())
        private set
    var organizers by mutableStateOf<List<User>>(emptyList())
        private set

    fun loadEvents() {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            try {
                eventsList = eventsRepository.getEvents()
            } catch (e: Exception) {
                errorMessage = e.message
            } finally {
                isLoading = false
            }
        }
    }

    fun loadEventDetail(id: String) {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            try {
                selectedEvent = eventsRepository.getEventDetail(id)
                val participants_tmp = mutableListOf<User>()
                val organizers_tmp = mutableListOf<User>()

                if (selectedEvent != null) {
                    for (participant in selectedEvent!!.participants) {
                        // Ajoute un participant
                        participants_tmp.add(userRepository.getUserById(participant))
                    }

                    for (organizer in selectedEvent!!.organizers) {
                        organizers_tmp.add(userRepository.getUserById(organizer))
                    }

                    participants = participants_tmp.toList()
                    organizers = organizers_tmp.toList()

                }
            } catch (e: Exception) {
                errorMessage = e.message
            } finally {
                isLoading = false
            }
        }
    }

    fun participateEvent(eventId: String, userId: String) {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            try {
                eventsRepository.addParticipant(eventId, userId)
                loadEventDetail(eventId)  // Mettre à jour l'event courant
            } catch (e: Exception) {
                errorMessage = e.message
            } finally {
                isLoading = false
            }
        }
    }
    // Ajoutez d'autres fonctions (update, delete, addParticipant, etc.) selon vos besoins.
}
