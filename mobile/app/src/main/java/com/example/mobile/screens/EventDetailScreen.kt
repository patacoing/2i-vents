package com.example.mobile.screens

//@Composable
//fun EventDetailScreen(eventId: String, viewModel: EventsViewModel) {
//    val event = viewModel.selectedEvent
//
//    LaunchedEffect(eventId) {
//        viewModel.loadEventDetail(eventId)
//    }
//
//    if (viewModel.isLoading) {
//        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//            CircularProgressIndicator()
//        }
//    } else {
//        event?.let {
//            Column(Modifier.padding(16.dp)) {
//                Text("Titre: ${it.title}", style = MaterialTheme.typography.headlineMedium)
//                Text("Date: ${it.date}", style = MaterialTheme.typography.bodyLarge)
//                Text("Description: ${it.description}", style = MaterialTheme.typography.bodyMedium)
//            }
//        } ?: Text("Aucun détail disponible")
//    }
//}
