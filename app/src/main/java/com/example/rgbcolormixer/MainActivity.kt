package com.example.rgbcolormixer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rgbcolormixer.ui.theme.RGBColorMixerTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.background




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RGBColorMixerTheme {
                Sliders()

                }
            }
        }
    }


@Composable
fun Sliders() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    var sliderPosition2 by remember { mutableFloatStateOf(0f) }
    var sliderPosition3 by remember { mutableFloatStateOf(0f) }

    val red = sliderPosition.toInt()
    val green = sliderPosition2.toInt()
    val blue = sliderPosition3.toInt()

    val color = Color(red / 255f, green / 255f, blue / 255f)


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Red: $red", color = Color.Red)
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..255f,
            colors = SliderDefaults.colors(
                thumbColor = Color.Red,
                activeTrackColor = Color.Red
            )
        )

        Text(text = "Green: $green", color = Color.Green)
        Slider(
            value = sliderPosition2,
            onValueChange = { sliderPosition2 = it },
            valueRange = 0f..255f,
            colors = SliderDefaults.colors(
                thumbColor = Color.Green,
                activeTrackColor = Color.Green
            )

        )

        Text(text = "Blue: $blue", color = Color.Blue)
        Slider(
            value = sliderPosition3,
            onValueChange = { sliderPosition3 = it },
            valueRange = 0f..255f,
            colors = SliderDefaults.colors(
                thumbColor = Color.Blue,
                activeTrackColor = Color.Blue
            )

        )

        Text(
            text = "Selected Color",
            modifier = Modifier
                .size(200.dp)
                .fillMaxWidth()
                .background(color = color)

        )

    }

}


@Preview(showBackground = true)
@Composable
fun SlidersPreview() {
    RGBColorMixerTheme {
        Sliders()
    }
}