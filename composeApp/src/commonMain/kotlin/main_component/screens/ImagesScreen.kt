package main_component.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun ImagesScreen() {
    Box(Modifier.background(Color.Red).fillMaxSize()) {
        Text("ImagesScreen", fontSize = 30.sp)
    }
}