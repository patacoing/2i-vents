package com.example.mobile.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mobile.viewmodels.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    onSignUpSuccess: () -> Unit,
    viewModel: AuthViewModel = hiltViewModel()
) {
    var firstname by remember { mutableStateOf("") }
    var lastname by remember { mutableStateOf("") }
    var promotion by remember { mutableStateOf("LE1") }
    var password by remember { mutableStateOf("") }
    var expandedPromotionMenu by remember { mutableStateOf(false) }

    val promotions = listOf("LE1", "LE2", "LE3", "LE4", "LE5", "LA1", "LA2", "LA3")

    val isLoading = viewModel.isLoading
    val registeredUser = viewModel.registeredUser
    val error = viewModel.errorMessage
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
                .clip(RoundedCornerShape(16.dp))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                "Inscription",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = firstname,
                onValueChange = { firstname = it },
                label = { Text("Prénom") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outline
                )
            )

            OutlinedTextField(
                value = lastname,
                onValueChange = { lastname = it },
                label = { Text("Nom") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                )
            )

            // Menu déroulant pour la promotion
            ExposedDropdownMenuBox(
                expanded = expandedPromotionMenu,
                onExpandedChange = { expandedPromotionMenu = it },
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = promotion,
                    onValueChange = {},
                    label = { Text("Promotion") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(),
                    shape = RoundedCornerShape(12.dp),
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedPromotionMenu) }
                )

                ExposedDropdownMenu(
                    expanded = expandedPromotionMenu,
                    onDismissRequest = { expandedPromotionMenu = false }
                ) {
                    promotions.forEach { promotionOption ->
                        DropdownMenuItem(
                            text = { Text(promotionOption) },
                            onClick = {
                                promotion = promotionOption
                                expandedPromotionMenu = false
                            }
                        )
                    }
                }
            }

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Mot de passe") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    viewModel.register(firstname, lastname, promotion, password)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                enabled = !isLoading && firstname.isNotBlank() &&
                        lastname.isNotBlank() && promotion.isNotBlank() &&
                        password.isNotBlank()
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                } else {
                    Text(
                        "S'inscrire",
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }

            AnimatedVisibility(
                visible = error != null,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                error?.let {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.errorContainer
                        )
                    ) {
                        Text(
                            text = it,
                            color = MaterialTheme.colorScheme.error,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
        }
    }

    LaunchedEffect(registeredUser) {
        registeredUser?.let {
            onSignUpSuccess()
        }
    }
}