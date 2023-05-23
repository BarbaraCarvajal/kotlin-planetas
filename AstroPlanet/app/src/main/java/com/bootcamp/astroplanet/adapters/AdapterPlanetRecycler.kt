package com.example.navdrawer.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.astroplanet.databinding.ItemPlanetRecyBinding
import com.bootcamp.astroplanet.interfaces.listernerRecyclerPlanet
import com.bootcamp.astroplanet.models.Planet

class AdapterPlanetRecycler(
    private val listPlanet: MutableList<Planet>,
    private val planetListener: listernerRecyclerPlanet
) : RecyclerView.Adapter<AdapterPlanetRecycler.ViewHolderPlanet>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPlanet {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPlanetRecyBinding.inflate(inflater, parent, false)
        return ViewHolderPlanet(binding)
    }

    override fun getItemCount(): Int = listPlanet.size

    override fun onBindViewHolder(holder: ViewHolderPlanet, position: Int) {
        val planet = listPlanet[position]
        holder.bind(planet)
    }

    fun addPlanet(planet: Planet) {
        listPlanet.add(planet)
        notifyDataSetChanged()
    }

    inner class ViewHolderPlanet(private val binding: ItemPlanetRecyBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(planet: Planet) {
            // Aquí puedes configurar los datos del planeta en los elementos de la vista de ItemPlanetRecyBinding.
            // Por ejemplo, puedes establecer el nombre del planeta en un TextView usando binding.txtCity.text = planet.nombre.
            // También puedes implementar la lógica para manejar eventos de clic en el elemento.
            // Cuando se haga clic en el elemento, puedes llamar a planetListener.onCLickListener(planet) para notificar al listener externo.
        }
    }
}
