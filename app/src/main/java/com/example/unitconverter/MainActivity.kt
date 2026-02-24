package com.example.unitconverter

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                )
                {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter() {
    var inputVal by remember { mutableStateOf("") }
    var outputVal by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Centimeter") }
    var outputUnit by remember { mutableStateOf("Meter") }
    var expanded by remember { mutableStateOf(false) }
    var expanded2 by remember { mutableStateOf(false) }
    var iConverter by remember { mutableDoubleStateOf(0.01) }
    var oConverter by remember { mutableDoubleStateOf(1.0) }

    fun converter() {
        val inputToDouble = inputVal.toDoubleOrNull() ?: 0.0
        val result = (inputToDouble * iConverter * 100.0 / oConverter).roundToInt() / 100.0
        outputVal = result.toString()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text("Unit Converter", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = inputVal,
            onValueChange = {
                inputVal = it
                converter()
            },
            label = { Text("Enter Value") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Box {
                Button(onClick = { expanded = true }) {
                    Text(inputUnit)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("Meter") },
                        onClick = {
                            inputUnit = "Meter"
                            iConverter = 1.0
                            expanded = false
                            converter()
                        }
                    )

                    DropdownMenuItem(
                        text = { Text("Centimeter") },
                        onClick = {
                            inputUnit = "Centimeter"
                            iConverter = 0.01
                            expanded = false
                            converter()
                        }
                    )

                    DropdownMenuItem(
                        text = { Text("Kilometer") },
                        onClick = {
                            inputUnit = "Kilometer"
                            iConverter = 1000.0
                            expanded = false
                            converter()
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.width(20.dp))

            Box {
                Button(onClick = { expanded2 = true }) {
                    Text(outputUnit)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }

                DropdownMenu(
                    expanded = expanded2,
                    onDismissRequest = { expanded2 = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("Meter") },
                        onClick = {
                            outputUnit = "Meter"
                            oConverter = 1.0
                            expanded2 = false
                            converter()
                        }
                    )

                    DropdownMenuItem(
                        text = { Text("Centimeter") },
                        onClick = {
                            outputUnit = "Centimeter"
                            oConverter = 0.01
                            expanded2 = false
                            converter()
                        }
                    )

                    DropdownMenuItem(
                        text = { Text("Kilometer") },
                        onClick = {
                            outputUnit = "Kilometer"
                            oConverter = 1000.0
                            expanded2 = false
                            converter()
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text("Result: $outputVal $outputUnit", style = MaterialTheme.typography.headlineSmall)
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverterTheme {
        UnitConverter()
    }
}
// day 6 done