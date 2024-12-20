package com.example.mobile.repositories

import com.example.mobile.models.User
import com.example.mobile.services.UserApiService
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userApi: UserApiService
) {
    suspend fun getAllUsers(): List<User> = userApi.getAllUsers()
    suspend fun getUserById(id: String): User = userApi.getUserById(id)
    suspend fun updateUser(id: String, user: User): User = userApi.updateUser(id, user)
    suspend fun deleteUser(id: String) {
        userApi.deleteUser(id)
    }
}
