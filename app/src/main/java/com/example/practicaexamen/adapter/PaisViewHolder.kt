package com.example.practicaexamen.adapter

import android.view.ContextMenu
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaexamen.domain.Pais
import com.example.practicaexamen.databinding.ListItemPaisBinding

class PaisViewHolder (view: View): RecyclerView.ViewHolder(view), View.OnCreateContextMenuListener {
    val binding = ListItemPaisBinding.bind(view)
    private lateinit var pais: Pais


    fun render(item: Pais, onClickListener: (Pais) -> Unit) {
        binding.tvNombrePais.text = item.nombre_pais
        binding.ivBanderaPais.setImageResource(item.bandera_pais)
        binding.ivBanderaUe.setImageResource(item.bandera_ue)
        itemView.setOnClickListener {
            onClickListener(item)
        }
        pais = item
        itemView.setOnCreateContextMenuListener(this)

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menu!!.setHeaderTitle(pais.nombre_pais)
        menu.add(this.adapterPosition, 0, 0, "Eliminar")
        menu.add(this.adapterPosition, 1, 1, "Editar")
    }
}