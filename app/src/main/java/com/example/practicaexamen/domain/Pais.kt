package com.example.practicaexamen.domain

class Pais(
    val id:Int,
    var nombre_pais: String,
    val bandera_pais: Int,
    val bandera_ue: Int,
    val territorio: Int,
    val poblacion: String,
    var capital: String,
    var miembro_ue: String,
    val latitud:Double, //Para OpenStreetMaps
    val longitud:Double //Para OpenStreetMaps
)
