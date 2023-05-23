package com.bootcamp.astroplanet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bootcamp.astroplanet.databinding.ActivityMainBinding
import com.bootcamp.astroplanet.interfaces.listernerRecyclerPlanet
import com.bootcamp.astroplanet.models.Planet
import com.example.navdrawer.adapters.AdapterPlanetRecycler

class MainActivity : AppCompatActivity(), listernerRecyclerPlanet {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAdapterPlanet: AdapterPlanetRecycler
    private lateinit var mLayoutManager: GridLayoutManager
    private lateinit var mLayoutManagerLinear: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.addButton?.setOnClickListener { addPlanet() }

       // mBinding.addButton.setOnClickListener { addPlanet() }
        setupRecyclerView()
    }

    private fun addPlanet() {
        val planetName = mBinding.planetInput.editText?.text.toString()
        val planet = Planet(nombre = planetName)
        mAdapterPlanet.addPlanet(planet)
    }

    private fun setupRecyclerView() {
        mAdapterPlanet = AdapterPlanetRecycler(mutableListOf(), this)
        mLayoutManager = GridLayoutManager(this, 2)
        mLayoutManagerLinear = LinearLayoutManager(this)

        mBinding.recyclerPlanetas.apply {
            setHasFixedSize(true)
            layoutManager = mLayoutManager
            adapter = mAdapterPlanet
        }
    }
    

    override fun onCLickListener(planet: Planet) {
        // Aquí puedes implementar la acción que deseas realizar cuando se hace clic en un planeta del RecyclerView
    }
}
