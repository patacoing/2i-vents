package com.example.mobile.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.mobile.services.SignUpRequest
import com.example.mobile.viewmodels.AuthViewModel

@Composable
fun SignUpScreen(onSignUpSuccess: () -> Unit, viewModel: AuthViewModel) {
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(Modifier.padding(16.dp)) {
        Text("Inscription")
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        TextField(value = password, onValueChange = { password = it }, label = { Text("Mot de passe") })
        Button(
            onClick = {
                viewModel.signUp(SignUpRequest(email, password))
            }
        ) {
            Text("S'inscrire")
        }

        if (viewModel.signUpState != null) {
            // Si succès
            LaunchedEffect(Unit) {
                onSignUpSuccess()
            }
        }

        if (viewModel.isLoading) {
            CircularProgressIndicator()
        }
    }
}