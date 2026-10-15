package com.example.pertemuan5

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun FormDataDiri(modifier: Modifier = Modifier) {
    // variabel-variabel untuk mengingat nilai masukan dari keyboard
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJk by remember { mutableStateOf("") }
    val gender: List<String> = listOf("Laki-laki", "Perempuan")

    // variabel-variabel untuk menyimpan data yang diperoleh dari komponen UI
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }

    Column(
        modifier = modifier.padding(top = 50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = textNama,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(250.dp),
            label = { Text(text = "Nama Lengkap") },
            onValueChange = {
                textNama = it
            }
        )

        Row {
            gender.forEach { item ->
                Row(
                    modifier = Modifier.selectable(
                        selected = textJk == item,
                        onClick = { textJk = item }
                    ),
                    verticalAlignment = Alignment.CenterVertically // Perbaikan typo 'vertikalAligment' dan 'Aligment'
                ) {
                    RadioButton(
                        selected = textJk == item, // Perbaikan case sensitive 'textJK' menjadi 'textJk'
                        onClick = {                // Perbaikan typo 'OnClik' menjadi 'onClick'
                            textJk = item
                        }
                    )
                    Text(text = item)
                }
            }
        }

        OutlinedTextField(
            value = textAlamat,
            singleLine = true,
            modifier = Modifier.width(250.dp),
            label = { Text("Alamat") },
            onValueChange = {
                textAlamat = it
            }
        )

        Divider(
            modifier = Modifier.padding(
                bottom = dimensionResource(id = R.dimen.padding_medium),
                top = dimensionResource(id = R.dimen.padding_medium)
            ),
            thickness = dimensionResource(id = R.dimen.divider_tipis),
            color = Color.DarkGray
        )

        Button(
            modifier = Modifier.fillMaxWidth(fraction = 1f),
            enabled = textAlamat.isNotEmpty(),
            onClick = {
                nama = textNama
                jenis = textJk // Perbaikan case sensitive
                alamat = textAlamat
            }
        ) {
            // Gunakan R.string.submit jika string tersebut ada di strings.xml,
            // atau cukup gunakan Text("Submit") jika ingin langsung teks.
            Text("Submit")
        }

        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Black),
            modifier = Modifier
                .height(100.dp)
                .width(300.dp)
        ) {
            // Area untuk isi di dalam kartu (card)
        }
    }
}