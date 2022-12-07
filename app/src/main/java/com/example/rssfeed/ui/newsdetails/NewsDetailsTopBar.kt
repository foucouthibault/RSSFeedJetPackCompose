package com.example.rssfeed.ui.newsdetails

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun NewsDetailsTopBar(onBack: () -> Unit) {
    TopAppBar(backgroundColor = Color.Cyan) {
        IconButton(onClick = { onBack() }) {
            Icon(Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
        }
    }
}