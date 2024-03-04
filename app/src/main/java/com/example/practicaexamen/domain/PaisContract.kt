package com.example.practicaexamen.domain

import android.provider.BaseColumns

class PaisContract {
    companion object{
        const val NOMBRE_DB = "paises_de_europa"

        const val VERSION = 1

        class Entrada : BaseColumns {
            companion object{
                const val NOMBRE_TABLA = "paises"
                const val COLUMNA_ID = "id"
                const val COLUMNA_NOMBRE_PAIS = "nombre_pais"
                const val COLUMNA_BANDERA_PAIS = "bandera_pais"
                const val COLUMNA_BANDERA_UE = "bandera_ue"
                const val COLUMNA_TERRITORIO = "territorio"
                const val COLUMNA_POBLACION = "poblacion"
                const val COLUMNA_CAPITAL = "capital"
                const val COLUMNA_MIEMBRO_UE = "miembro_ue"
                const val COLUMNA_LATITUD = "latitud"
                const val COLUMNA_LONGITUD = "longitud"
            }
        }
    }
}