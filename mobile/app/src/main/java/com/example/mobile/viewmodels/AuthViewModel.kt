package com.example.mobile.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile.models.AuthResponse
import com.example.mobile.models.User
import com.example.mobile.repositories.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    var authResponse by mutableStateOf<AuthResponse?>(null)
        private set
    var registeredUser by mutableStateOf<User?>(null)
        private set
    var isLoading by mutableStateOf(false)
        private set
    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun login(firstName: String, lastName: String, password: String) {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            try {
                authResponse = authRepository.login(firstName, lastName, password)
            } catch (e: Exception) {
                errorMessage = e.message
            } finally {
                isLoading = false
            }
        }
    }

    fun register(firstName: String, lastName: String, promotion: String, password: String) {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            try {
                registeredUser = authRepository.register(firstName, lastName, promotion, password)
            } catch (e: Exception) {
                errorMessage = e.message
            } finally {
                isLoading = false
            }
        }
    }
}
