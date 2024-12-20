package com.example.mobile.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile.repositories.AuthRepository
import com.example.mobile.services.LoginRequest
import com.example.mobile.services.LoginResponse
import com.example.mobile.services.SignUpRequest
import com.example.mobile.services.SignUpResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    var signUpState by mutableStateOf<SignUpResponse?>(null)
        private set

    var loginState by mutableStateOf<LoginResponse?>(null)
        private set

    var isLoading by mutableStateOf(false)
        private set

    fun signUp(user: SignUpRequest) {
        viewModelScope.launch {
            isLoading = true
            try {
                signUpState = authRepository.signUp(user)
            } catch (e: Exception) {
                // Gérer l'erreur
            } finally {
                isLoading = false
            }
        }
    }

    fun login(creds: LoginRequest) {
        viewModelScope.launch {
            isLoading = true
            try {
                loginState = authRepository.login(creds)
            } catch (e: Exception) {
                // Gérer l'erreur
            } finally {
                isLoading = false
            }
        }
    }
}
