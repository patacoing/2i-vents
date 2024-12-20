package com.example.mobile.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.LaunchedEffect
import com.example.mobile.services.LoginRequest
import com.example.mobile.viewmodels.AuthViewModel


@Composable
fun LoginScreen(onLoginSuccess: () -> Unit, viewModel: AuthViewModel) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(Modifier.padding(16.dp)) {
        Text("Connexion")
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        TextField(value = password, onValueChange = { password = it }, label = { Text("Mot de passe") })
        Button(
            onClick = {
                viewModel.login(LoginRequest(email, password))
            }
        ) {
            Text("Se connecter")
        }

        if (viewModel.loginState != null) {
            LaunchedEffect(Unit) {
                onLoginSuccess()
            }
        }

        if (viewModel.isLoading) {
            CircularProgressIndicator()
        }
    }
}
