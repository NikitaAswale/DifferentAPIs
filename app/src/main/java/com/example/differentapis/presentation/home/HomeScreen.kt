package com.example.differentapis.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onGetClick: () -> Unit,
    onPostClick: () -> Unit,
    onPutClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Different APIs") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Select an API Operation",
                style = MaterialTheme.typography.headlineMedium
            )
            Button(
                onClick = onGetClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("GET - Fetch Posts")
            }
            Button(
                onClick = onPostClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("POST - Create Post")
            }
            Button(
                onClick = onPutClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("PUT - Update Post")
            }
            Button(
                onClick = onDeleteClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("DELETE - Remove Post")
            }
        }
    }
}
