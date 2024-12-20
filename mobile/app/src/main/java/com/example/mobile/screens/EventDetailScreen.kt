package com.example.mobile.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mobile.viewmodels.EventsViewModel

@Composable
fun EventDetailScreen(
    eventId: String,
    viewModel: EventsViewModel = hiltViewModel()
) {
    val event = viewModel.selectedEvent
    val isLoading = viewModel.isLoading
    val error = viewModel.errorMessage

    LaunchedEffect(eventId) {
        viewModel.loadEventDetail(eventId)
    }

    if (isLoading) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else if (error != null) {
        Text("Erreur : $error", color = Color.Red, modifier = Modifier.padding(16.dp))
    } else {
        event?.let {
            Column(Modifier.padding(16.dp)) {
                Text("Titre: ${it.name}", style = MaterialTheme.typography.headlineMedium)
                Text("Date: ${it.date}", style = MaterialTheme.typography.bodyLarge)
                Text("Description: ${it.description}", style = MaterialTheme.typography.bodyMedium)
            }
        } ?: Text("Aucun détail disponible")
    }
}
