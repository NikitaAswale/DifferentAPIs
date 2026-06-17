package com.example.differentapis.presentation.put

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PutScreen(
    onBackClick: () -> Unit,
    viewModel: PutViewModel = hiltViewModel()
) {
    val updatedPost by viewModel.updatedPost.collectAsState()
    var postId by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }
    var title by remember { mutableStateOf("") }
    var body by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("PUT - Update Post") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = postId,
                onValueChange = { postId = it },
                label = { Text("Post ID") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = id,
                onValueChange = { id = it },
                label = { Text("ID") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = body,
                onValueChange = { body = it },
                label = { Text("Body") },
                modifier = Modifier.fillMaxWidth(),
                minLines = 3
            )
            Button(
                onClick = { viewModel.updatePost(postId, id.toIntOrNull() ?:0 ,title, body) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Update Post")
            }
            if (updatedPost != null) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Updated Post ID: ${updatedPost!!.id}",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = "Id: ${updatedPost!!.userId}")
                        Text(text = "Title: ${updatedPost!!.title}")
                        Text(text = "Body: ${updatedPost!!.body}")
                    }
                }
            }
        }
    }
}
