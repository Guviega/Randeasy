package dev.guviega.randeasy

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreen(viewModel: RandomViewModel = viewModel()) {

    val result = viewModel.result

    var start by remember { mutableStateOf("") }
    var end by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row() {
            Text(
                "🎲 Randeasy",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.paddingFromBaseline(top = 100.dp)
            )
        }


        HorizontalDivider(modifier = Modifier.paddingFromBaseline(top = 50.dp), DividerDefaults.Thickness, DividerDefaults.color)
        Row() {
            Text(
                "Draw  ",
                modifier = Modifier
                    .paddingFromBaseline(top = 40.dp),
                style = MaterialTheme.typography.titleLarge
            )
            OutlinedTextField(
                modifier = Modifier
                    .width(100.dp),
                value = quantity,
                onValueChange = { quantity = it },
                label = { Text("Quantity") }
            )
            Text(
                "  number(s)",
                modifier = Modifier
                    .paddingFromBaseline(top = 40.dp),
                style = MaterialTheme.typography.titleLarge
            )
        }

        Row() {
            Text(
                "From  ",
                modifier = Modifier
                    .paddingFromBaseline(top = 40.dp),
                style = MaterialTheme.typography.titleLarge
            )
            OutlinedTextField(
                modifier = Modifier
                    .width(100.dp),
                value = start,
                onValueChange = { start = it },
                label = { Text("Start") }
            )
            Text(
                "  to  ",
                modifier = Modifier
                    .paddingFromBaseline(top = 40.dp),
                style = MaterialTheme.typography.titleLarge
            )
            OutlinedTextField(
                modifier = Modifier
                    .width(100.dp),
                value = end,
                onValueChange = { end = it },
                label = { Text("End") }
            )
        }

        Button(
            onClick = {
                viewModel.drawFromRange(
                    start.toIntOrNull() ?: 0,
                    end.toIntOrNull() ?: 0,
                    quantity.toIntOrNull() ?: 1
                )
            }
        ) {
            Text(
                "Draw numbers🎲",
                style = MaterialTheme.typography.titleLarge
            )
        }

        HorizontalDivider(modifier = Modifier.paddingFromBaseline(bottom = 20.dp), DividerDefaults.Thickness, DividerDefaults.color)

        Text("Result:")

        result.forEach {
            Text("👉 $it")
        }
    }
}