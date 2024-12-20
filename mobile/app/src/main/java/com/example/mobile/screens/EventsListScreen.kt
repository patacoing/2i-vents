package com.example.mobile.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
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
fun EventsListScreen(
    onEventSelected: (String) -> Unit,
    viewModel: EventsViewModel = hiltViewModel()
) {
    val events = viewModel.eventsList
    val isLoading = viewModel.isLoading
    val error = viewModel.errorMessage

    LaunchedEffect(Unit) {
        viewModel.loadEvents()
    }

    if (isLoading) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else if (error != null) {
        Text("Erreur : $error", color = Color.Red, modifier = Modifier.padding(16.dp))
    } else {
        LazyColumn {
            items(events) { event ->
                Text(
                    text = event.name,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable { onEventSelected(event.id) }
                )
            }
        }
    }
}
