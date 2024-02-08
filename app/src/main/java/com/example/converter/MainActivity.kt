package com.example.converter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.converter.ui.theme.ConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConverterTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Converter()
                }
            }
        }
    }
}

@Composable
fun Converter() {
    var celsius by remember { mutableStateOf(0) }
    var fahrenheit by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        TextField(
            value = celsius.toString(),
            onValueChange = { value ->
                celsius = value.toIntOrNull() ?: 0
                fahrenheit = (celsius * 9 / 5) + 32
            },
            label = { Text("Enter Celsius") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Fahrenheit: $fahrenheit")
    }
}

@Preview(showBackground = true)
@Composable
fun ConverterPreview() {
    ConverterTheme {
        Converter()
    }
}
