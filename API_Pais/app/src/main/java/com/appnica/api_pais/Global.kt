package com.appnica.api_pais

data class Paises(

    val name: Name,
    val flags: Flags
)

data class Name(

    val common: String,
    val official: String
)

data class Flags(

    val png: String,
    val alt: String
)

lateinit var listaPaises: List<Paises>