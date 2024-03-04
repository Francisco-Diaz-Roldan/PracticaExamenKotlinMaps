package com.example.practicaexamen.domain

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.practicaexamen.adapter.PaisProvider

class DBOpenHelper private constructor(context: Context?):
    SQLiteOpenHelper(context, PaisContract.NOMBRE_DB, null, PaisContract.VERSION) {

    override fun onCreate(sqLiteDatabase: SQLiteDatabase?) {
        try {
            sqLiteDatabase?.execSQL(
                "CREATE TABLE ${PaisContract.Companion.Entrada.NOMBRE_TABLA}" +
                        "(${PaisContract.Companion.Entrada.COLUMNA_ID} INTEGER NOT NULL" +
                        ",${PaisContract.Companion.Entrada.COLUMNA_NOMBRE_PAIS} NVARCHAR(20)" +
                        ",${PaisContract.Companion.Entrada.COLUMNA_BANDERA_PAIS} INTEGER NOT NULL" +
                        ",${PaisContract.Companion.Entrada.COLUMNA_BANDERA_UE} INTEGER NOT NULL" +
                        ",${PaisContract.Companion.Entrada.COLUMNA_TERRITORIO} INTEGER NOT NULL" +
                        ",${PaisContract.Companion.Entrada.COLUMNA_POBLACION} NVARCHAR(20)" +
                        ",${PaisContract.Companion.Entrada.COLUMNA_CAPITAL} INTEGER NOT NULL" +
                        ",${PaisContract.Companion.Entrada.COLUMNA_MIEMBRO_UE} TEXT CHECK" +
                        "(${PaisContract.Companion.Entrada.COLUMNA_MIEMBRO_UE} IN ('true','false'))" +
                        ",${PaisContract.Companion.Entrada.COLUMNA_LATITUD} REAL NOT NULL" +
                        ",${PaisContract.Companion.Entrada.COLUMNA_LONGITUD} REAL NOT NULL);"
            )

            //Inserto los datos en la tabla
            inicializarBBDD(sqLiteDatabase)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun inicializarBBDD(db: SQLiteDatabase?) {
        val lista = PaisProvider.listaPaises
        for (pais in lista) {
            db?.execSQL(
                "INSERT INTO ${PaisContract.Companion.Entrada.NOMBRE_TABLA}(" +
                        "${PaisContract.Companion.Entrada.COLUMNA_ID}," +
                        "${PaisContract.Companion.Entrada.COLUMNA_NOMBRE_PAIS}," +
                        "${PaisContract.Companion.Entrada.COLUMNA_BANDERA_PAIS}," +
                        "${PaisContract.Companion.Entrada.COLUMNA_BANDERA_UE}," +
                        "${PaisContract.Companion.Entrada.COLUMNA_TERRITORIO}," +
                        "${PaisContract.Companion.Entrada.COLUMNA_POBLACION}," +
                        "${PaisContract.Companion.Entrada.COLUMNA_CAPITAL}," +
                        "${PaisContract.Companion.Entrada.COLUMNA_MIEMBRO_UE}," +
                        "${PaisContract.Companion.Entrada.COLUMNA_LATITUD}," +
                        "${PaisContract.Companion.Entrada.COLUMNA_LONGITUD})" +
                        " VALUES (" +
                        "${pais.id}," +
                        "'${pais.nombre_pais}'," +
                        "${pais.bandera_pais}," +
                        "${pais.bandera_ue}," +
                        "${pais.territorio}," +
                        "'${pais.poblacion}'," +
                        "'${pais.capital}'," +
                        "'${pais.miembro_ue}',"+
                        "${pais.latitud},"+
                        "${pais.longitud});"//Revisar que solo haya comillas simples en strings y no en ints ni doubles
            )
        }
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ${PaisContract.Companion.Entrada.NOMBRE_TABLA};")
        onCreate(sqLiteDatabase)
    }

    companion object {
        private var dbOpen: DBOpenHelper? = null
        fun getInstance(context: Context?): DBOpenHelper? {
            if (dbOpen == null) dbOpen = DBOpenHelper(context)
            return dbOpen
        }
    }
}