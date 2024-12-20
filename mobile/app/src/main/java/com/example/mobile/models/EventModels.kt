package com.example.mobile.models

data class Address(
    val name: String,
    val city: String,
    val zipCode: String,
    val streetName: String,
    val streetNumber: String
)

data class Event(
    val _id: String,
    val name: String,
    val description: String,
    val address: Address,
    val participants: List<String>,
    val organizers: List<String>,
    val date: String,
    val time: String,
    val themes: List<String>
)

data class NewEvent(
    val name: String,
    val description: String,
    val address: Address,
    val organizers: List<String>,
    val date: String,
    val time: String,
    val themes: List<String>
)

data class UpdateEvent(
    val name: String?,
    val description: String?,
    val address: Address?,
    val date: String?,
    val time: String?,
    val themes: List<String>?
)

data class Participant(
    val userId: Int
)

data class Organizer(
    val userId: Int
)
