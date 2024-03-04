package com.example.practicaexamen.domain

import android.content.Context
import android.database.Cursor

class PaisDAO {
    fun cargarTodosLosPaises(context: Context?):MutableList<Pais>{
        lateinit var res: MutableList<Pais>
        lateinit var c: Cursor
        try {
            val db = DBOpenHelper.getInstance(context)!!.readableDatabase
            val sql = "SELECT * FROM paises;"
            c = db.rawQuery(sql, null)
            res = mutableListOf()
            // Leo los resultados del cursor y los meto en la lista
            while (c.moveToNext()) {
                val nuevo = Pais(
                    c.getInt(0),
                    c.getString(1),
                    c.getInt(2),
                    c.getInt(3),
                    c.getInt(4),
                    c.getString(5),
                    c.getString(6),
                    c.getString(7),
                    c.getDouble(8),
                    c.getDouble(9)
                )
                res.add(nuevo)
            }
        } finally {
            c.close()
        }
        return res
    }

    fun cargarPaisesUE(context: Context?):MutableList<Pais>{
        lateinit var res: MutableList<Pais>
        lateinit var c: Cursor
        try {
            val db = DBOpenHelper.getInstance(context)!!.readableDatabase
            val sql = "SELECT * FROM ${PaisContract.Companion.Entrada.NOMBRE_TABLA} " +
                    "WHERE ${PaisContract.Companion.Entrada.COLUMNA_MIEMBRO_UE} = 'true';"
            c = db.rawQuery(sql, null)
            res = mutableListOf()
            // Leo los resultados del cursor y los meto en la lista
            while (c.moveToNext()) {
                val nuevo = Pais(
                    c.getInt(0),
                    c.getString(1),
                    c.getInt(2),
                    c.getInt(3),
                    c.getInt(4),
                    c.getString(5),
                    c.getString(6),
                    c.getString(7),
                    c.getDouble(8),
                    c.getDouble(9)
                )
                res.add(nuevo)
            }
        } finally {
            c.close()
        }
        return res
    }

    fun cargarPaisesFueraUE(context: Context?):MutableList<Pais>{
        lateinit var res: MutableList<Pais>
        lateinit var c: Cursor
        try {
            val db = DBOpenHelper.getInstance(context)!!.readableDatabase
            val sql = "SELECT * FROM ${PaisContract.Companion.Entrada.NOMBRE_TABLA} " +
                    "WHERE ${PaisContract.Companion.Entrada.COLUMNA_MIEMBRO_UE} = 'false';"
            c = db.rawQuery(sql, null)
            res = mutableListOf()
            // Leo los resultados del cursor y los meto en la lista
            while (c.moveToNext()) {
                val nuevo = Pais(
                    c.getInt(0),          // Columna ID
                    c.getString(1),       // Columna NOMBRE_PAIS
                    c.getInt(2),          // Columna BANDERA_PAIS
                    c.getInt(3),          // Columna BANDERA_UE
                    c.getInt(4),          // Columna TERRITORIO
                    c.getString(5),       // Columna POBLACION
                    c.getString(6),       // Columna CAPITAL
                    c.getString(7),       // Columna MIEMBRO_UE
                    c.getDouble(8),       // Columna LATITUD
                    c.getDouble(9)        // Columna LONGITUD
                )
                res.add(nuevo)
            }
        } finally {
            c.close()
        }
        return res
    }
}