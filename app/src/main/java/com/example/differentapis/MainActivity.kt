package com.example.differentapis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.differentapis.presentation.delete.DeleteScreen
import com.example.differentapis.presentation.get.GetScreen
import com.example.differentapis.presentation.home.HomeScreen
import com.example.differentapis.presentation.post.PostScreen
import com.example.differentapis.presentation.put.PutScreen
import com.example.differentapis.ui.theme.DifferentAPIsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DifferentAPIsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "home"
                    ) {
                        composable("home") {
                            HomeScreen(
                                onGetClick = { navController.navigate("get") },
                                onPostClick = { navController.navigate("post") },
                                onPutClick = { navController.navigate("put") },
                                onDeleteClick = { navController.navigate("delete") }
                            )
                        }
                        composable("get") {
                            GetScreen(onBackClick = { navController.popBackStack() })
                        }
                        composable("post") {
                            PostScreen(onBackClick = { navController.popBackStack() })
                        }
                        composable("put") {
                            PutScreen(onBackClick = { navController.popBackStack() })
                        }
                        composable("delete") {
                            DeleteScreen(onBackClick = { navController.popBackStack() })
                        }
                    }
                }
            }
        }
    }
}