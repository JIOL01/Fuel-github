package com.appnica.api_libre

data class Houses(
    val slug: String,
    val name: String,
    val members: Array<Members>
)

data class Members(
    val name: String,
    val slug: String
)

lateinit var listaHouse: List<Houses>
