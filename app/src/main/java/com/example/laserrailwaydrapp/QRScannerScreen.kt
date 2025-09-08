package com.example.laserrailwaydrapp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun QRScannerScreen(user: User?) {
    var scannedData by remember { mutableStateOf("No data scanned") }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("QR Code Scanner", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            scannedData = "Sample scanned QR data"
            // TODO: Integrate actual QR code scanning library later
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Scan QR Code")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("Scanned Data: $scannedData")


    }
}
