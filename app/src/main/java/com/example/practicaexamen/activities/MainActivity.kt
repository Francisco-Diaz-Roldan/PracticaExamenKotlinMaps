package com.example.practicaexamen.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicaexamen.R
import com.example.practicaexamen.adapter.PaisAdapter
import com.example.practicaexamen.databinding.ActivityMainBinding
import com.example.practicaexamen.domain.Pais
import com.example.practicaexamen.domain.PaisDAO

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var paisDAO: PaisDAO = PaisDAO()
    private lateinit var listaPaises: List<Pais>
    private lateinit var adapter: PaisAdapter
    private lateinit var intentLaunch: ActivityResultLauncher<Intent>
    private var id: Int = 0
    private var nombrePais = "Sin nombre"
    private var bandera_pais= 0
    private var bandera_ue= 0
    private var territorio= 0
    private var poblacion = "Sin poblacion"
    private var capital = "Sin capital"
    private var miembro_ue = "false"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listaPaises = paisDAO.cargarTodosLosPaises(this)
        binding.rvPais.layoutManager = LinearLayoutManager(this)
        binding.rvPais.adapter =
            PaisAdapter(listaPaises) { comunidadAutonoma ->
                onItemSelected(comunidadAutonoma)
            }

        intentLaunch =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val data = result.data
                    val id = data?.getIntExtra("id", 0)
                    nombrePais = data?.extras?.getString("nombrePais").toString()
                    capital = data?.extras?.getString("capital").toString()
                    bandera_pais = data?.extras?.getInt("banderaPais", 0) ?: 0
                    bandera_ue = data?.extras?.getInt("banderaUE", 0) ?: 0
                    territorio = data?.extras?.getInt("territorio", 0) ?: 0
                    poblacion = data?.extras?.getString("poblacion").toString()
                    miembro_ue = data?.extras?.getString("miembroUE").toString()
                }
            }
    }

    //Para crear el menú
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_desplegable, menu)
        return true
    }

    //Para cada una de las opciones del menú
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.union_europea -> {
                listaPaises = paisDAO.cargarPaisesUE(this)
                binding.rvPais.adapter?.notifyDataSetChanged()
                binding.rvPais.adapter = PaisAdapter(listaPaises) {
                    onItemSelected(it)
                }
                Toast.makeText(this, "Lista de países de la UE", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.resto_de_paises -> {
                listaPaises = paisDAO.cargarPaisesFueraUE(this)
                binding.rvPais.adapter?.notifyDataSetChanged()
                binding.rvPais.adapter = PaisAdapter(listaPaises) {
                    onItemSelected(it)
                }
                Toast.makeText(this, "Lista de países que no pertenecen a la UE", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.todos_los_paises -> {
                listaPaises = paisDAO.cargarTodosLosPaises(this)
                binding.rvPais.adapter?.notifyDataSetChanged()
                binding.rvPais.adapter = PaisAdapter(listaPaises) {
                    onItemSelected(it)
                }
                Toast.makeText(this, "Lista de todos los países, pertenezcan o no a la UE", Toast.LENGTH_SHORT).show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun onItemSelected(pais: Pais) {
    Toast.makeText(this, "Yo soy de ${pais.nombre_pais}", Toast.LENGTH_SHORT).show()
    // Para iniciar la actividad OpenStreetMapsActivity o en GoogleMapsActivity
    val intent = Intent(this, OpenStreetMapsActivity::class.java)
    //Aqui le meto solo lo que vaya a utilizar en el OpenStreetMaps
    intent.putExtra("nombrePais", pais.nombre_pais)
    intent.putExtra("capital", pais.capital)
    intent.putExtra("paisLatitud", pais.latitud) //Importante que tenga el mismo nombre que en OpenStreetMapasActivity
    intent.putExtra("paisLongitud", pais.longitud) //Importante que tenga el mismo nombre que en OpenStreetMapasActivity
    startActivity(intent)
    }
}

