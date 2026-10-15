package com.example.pertemuan5

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton

@Composable
fun FormDataDiri(modifier: Modifier){
    //variabel-variabel untuk mengingat nilai masukan dari keyboard
    var textNama by remember {mutableStateOf("")}
    var textAlamat by remember {mutableStateOf("")}
    var textJk by remember {mutableStateOf("")}
    val gender:List<String> = listOf("Laki-laki", "Perempuan")

    //variabel-variabel untuk menyimpan data yang diperoleh dari komponen UI
    var nama by remember {mutableStateOf("")}
    var alamat by remember {mutableStateOf("")}
    var jenis by remember {mutableStateOf("")}

    Column(modifier = Modifier.padding(top = 50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = textNama,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            onValueChange = {
                textNama = it
            }
        )

        Row {
            gender.forEach { item ->
                Row(modifier = Modifier.selectable(
                    selected = textJk == item,
                    onClick = { textJk = item }
                ), vertikalAligment = Aligment.CenterVertically) {
                    RadioButton(
                        selected = textJK == item,
                        OnClik = {
                            textJK = item
                        } )
                    Text(item)

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
            modifier = Modifier.padding(bottom =
                dimensionResource(id = R.dimen.padding_medium), top = dimensionResource(
                id = R.dimen.padding_medium
            )),
            thickness = dimensionResource(1dp),
            color = Color.DarkGray
        )

        Button(
            modifier = Modifier.fillMaxWidth(fraction = 1f),
            // the button is enabled when the user makes a selection
            enabled = textAlamat.isNotEmpty(),
            onClick = {
                nama=textNama
                jenis=textJK
                alamat=textAlamat
            }
        ) {
            Text(stringResource("Submit"))
        }
