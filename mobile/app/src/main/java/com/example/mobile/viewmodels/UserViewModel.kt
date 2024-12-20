package com.example.mobile.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile.models.User
import com.example.mobile.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    var users by mutableStateOf<List<User>>(emptyList())
        private set
    var selectedUser by mutableStateOf<User?>(null)
        private set
    var isLoading by mutableStateOf(false)
        private set
    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun loadUsers() {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            try {
                users = userRepository.getAllUsers()
            } catch (e: Exception) {
                errorMessage = e.message
            } finally {
                isLoading = false
            }
        }
    }

    fun loadUserById(id: String) {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            try {
                selectedUser = userRepository.getUserById(id)
            } catch (e: Exception) {
                errorMessage = e.message
            } finally {
                isLoading = false
            }
        }
    }

    fun updateUser(id: String, user: User) {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            try {
                selectedUser = userRepository.updateUser(id, user)
                // Vous pouvez mettre à jour la liste `users` si besoin.
            } catch (e: Exception) {
                errorMessage = e.message
            } finally {
                isLoading = false
            }
        }
    }

    fun deleteUser(id: String) {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            try {
                userRepository.deleteUser(id)
                users = users.filter { it.id != id } // Mettre à jour la liste en local
            } catch (e: Exception) {
                errorMessage = e.message
            } finally {
                isLoading = false
            }
        }
    }
}
