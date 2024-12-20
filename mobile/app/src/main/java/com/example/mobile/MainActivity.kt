package com.example.mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mobile.screens.EventDetailScreen
import com.example.mobile.screens.EventsListScreen
import com.example.mobile.screens.LoginScreen
import com.example.mobile.screens.Screen
import com.example.mobile.screens.SignUpScreen
import com.example.mobile.viewmodels.AuthViewModel
import com.example.mobile.viewmodels.EventsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppNavigation()
        }
    }
}

@Composable
fun MyAppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            val authViewModel = hiltViewModel<AuthViewModel>()
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Screen.EventsList.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                },
                onNavigateToSignUp = {
                    navController.navigate(Screen.SignUp.route)
                },
                viewModel = authViewModel
            )
        }

        composable(Screen.SignUp.route) {
            val authViewModel = hiltViewModel<AuthViewModel>()
            SignUpScreen(
                onSignUpSuccess = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.SignUp.route) { inclusive = true }
                    }
                },
                viewModel = authViewModel
            )
        }

        composable(Screen.EventsList.route) {
            val eventsViewModel = hiltViewModel<EventsViewModel>()
            EventsListScreen(
                onEventSelected = { eventId ->
                    navController.navigate(Screen.EventDetail.createRoute(eventId))
                },
                viewModel = eventsViewModel
            )
        }

        composable(
            Screen.EventDetail.route,
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { backStackEntry ->
            val eventsViewModel = hiltViewModel<EventsViewModel>()
            val eventId = backStackEntry.arguments?.getString("id") ?: ""
            EventDetailScreen(
                eventId = eventId,
                viewModel = eventsViewModel,
                onBackClick = { navController.navigateUp() } ,
                onRegisterClick = { /* Implémentez la logique d'inscription */ }
            )
        }
    }
}