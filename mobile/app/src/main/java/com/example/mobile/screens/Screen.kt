package com.example.mobile.screens

sealed class Screen(val route: String) {
    object SignUp : Screen("signup")
    object Login : Screen("login")
    object EventsList : Screen("events_list")
    object EventDetail : Screen("event_detail/{id}") {
        fun createRoute(id: String) = "event_detail/$id"
    }
}
