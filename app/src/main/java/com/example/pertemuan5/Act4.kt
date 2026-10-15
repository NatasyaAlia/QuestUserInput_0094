package com.example.pertemuan5

@Composable
fun FormDataDiri(modifier: Modifier){
    //variabel-variabel untuk mengingat nilai masukan dari keyboard
    var textNama by remember {mutableStateOf("")}
    var textAlamat by remember {mutableStateOf("")}
    var textJk by remember {mutableStateOf("")}
    val gender:List<String> = listOf("Laki-laki", "Perempuan")
}

}