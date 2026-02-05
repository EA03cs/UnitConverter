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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme

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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text("Unit Converter")
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = "",
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Box {
                Button(onClick = {}) {
                    Text("Select Unit")
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }

                DropdownMenu(
                    expanded = true,
                    onDismissRequest = {}
                ) {
                    Text("Meter", modifier = Modifier.padding(10.dp))
                    Text("Centimeter", modifier = Modifier.padding(10.dp))
                    Text("Kilometer", modifier = Modifier.padding(10.dp))
                }
            }

            Spacer(modifier = Modifier.width(20.dp))

            Box {
                Button(onClick = {}) {
                    Text("Select Unit")
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }

                DropdownMenu(
                    expanded = true,
                    onDismissRequest = {}
                ) {
                    Text("Meter", modifier = Modifier.padding(10.dp))
                    Text("Centimeter", modifier = Modifier.padding(10.dp))
                    Text("Kilometer", modifier = Modifier.padding(10.dp))
                }
            }
        }
        Text("result :")
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverterTheme {
        UnitConverter()
    }
}

