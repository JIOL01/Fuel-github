package com.appnica.api_libre2

data class Datas(

    val firstName: String,
    val lastName: String,
    val fullName: String,
    val family: String,
    val image: String,
    val imageUrl: String

)
lateinit var listaMovies: List<Datas>