package com.example.practicaexamen.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicaexamen.adapter.PaisProvider
import com.example.practicaexamen.databinding.ActivityOpenStreetMapsBinding
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.ItemizedIconOverlay
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus
import org.osmdroid.views.overlay.OverlayItem

private lateinit var  map: MapView
private lateinit var  binding: ActivityOpenStreetMapsBinding
class OpenStreetMapsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Configuration.getInstance()
            .load(applicationContext, this.getPreferences(Context.MODE_PRIVATE))
        binding = ActivityOpenStreetMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val paisLatitud = intent.getDoubleExtra("paisLatitud", 0.0)
        val paisLongitud = intent.getDoubleExtra("paisLongitud", 0.0)

        map = binding.map
        map.setTileSource(TileSourceFactory.MAPNIK)
        map.setMultiTouchControls(true)
        val mapController = map.controller
        mapController.setZoom(9.5)

        val items: ArrayList<OverlayItem> = ArrayList()

        val listaPaises = PaisProvider.listaPaises

        for (pais in listaPaises) {
            val overlayItem = OverlayItem(
                "${pais.nombre_pais} - Capital: ${pais.capital}",
                "Habitantes: ${pais.poblacion}",
                GeoPoint(pais.latitud, pais.longitud)
            )
            items.add(overlayItem)
        }

        val mOverlay: ItemizedOverlayWithFocus<OverlayItem> =
            ItemizedOverlayWithFocus(
                items,
                object : ItemizedIconOverlay.OnItemGestureListener<OverlayItem?>{
                    override fun onItemSingleTapUp(index: Int, item: OverlayItem?): Boolean {
                        return true
                    }

                    override fun onItemLongPress(index: Int, item: OverlayItem?): Boolean {
                        return false
                    }
                }, applicationContext
            )
        mOverlay.setFocusItemsOnTap(true)
        map.getOverlays().add(mOverlay)
        mapController.setCenter(GeoPoint(paisLatitud, paisLongitud))
    }

    public override fun onResume() {
        super.onResume()
        map.onResume()
    }

    public override fun onPause() {
        super.onPause()
        map.onPause()
    }
}