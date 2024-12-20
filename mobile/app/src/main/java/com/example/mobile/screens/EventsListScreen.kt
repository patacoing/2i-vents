package com.example.mobile.screens

//@Composable
//fun EventsListScreen(onEventSelected: (String) -> Unit, viewModel: EventsViewModel) {
//    val events = viewModel.eventsList
//
//    LaunchedEffect(Unit) {
//        viewModel.loadEvents()
//    }
//
//    if (viewModel.isLoading) {
//        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//            CircularProgressIndicator()
//        }
//    } else {
//        LazyColumn {
//            items(events) { event ->
//                Text(
//                    text = event.title,
//                    modifier = Modifier
//                        .padding(8.dp)
//                        .clickable { onEventSelected(event.id) }
//                )
//            }
//        }
//    }
//}
