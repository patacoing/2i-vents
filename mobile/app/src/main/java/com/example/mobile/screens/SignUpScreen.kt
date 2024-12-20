package com.example.mobile.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mobile.viewmodels.AuthViewModel

@Composable
fun SignUpScreen(
    onSignUpSuccess: () -> Unit,
    viewModel: AuthViewModel = hiltViewModel()
) {
    var firstname by remember { mutableStateOf("") }
    var lastname by remember { mutableStateOf("") }
    var promotion by remember { mutableStateOf("LE1") } // Valeur par défaut
    var password by remember { mutableStateOf("") }

    val isLoading = viewModel.isLoading
    val registeredUser = viewModel.registeredUser
    val error = viewModel.errorMessage

    Column(Modifier.padding(16.dp)) {
        Text("Inscription", style = MaterialTheme.typography.titleLarge)
        TextField(value = firstname, onValueChange = { firstname = it }, label = { Text("Prénom") })
        TextField(value = lastname, onValueChange = { lastname = it }, label = { Text("Nom") })
        TextField(value = promotion, onValueChange = { promotion = it }, label = { Text("Promotion") })
        TextField(value = password, onValueChange = { password = it }, label = { Text("Mot de passe") }, visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            viewModel.register(firstname, lastname, promotion, password)
        }) {
            Text("S'inscrire")
        }

        if (isLoading) {
            CircularProgressIndicator()
        }

        error?.let {
            Text("Erreur : $it", color = Color.Red)
        }

        // Si inscription réussie
        registeredUser?.let {
            LaunchedEffect(it) {
                onSignUpSuccess()
            }
        }
    }
}
