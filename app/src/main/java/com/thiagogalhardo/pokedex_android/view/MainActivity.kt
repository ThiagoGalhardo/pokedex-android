package com.thiagogalhardo.pokedex_android.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thiagogalhardo.pokedex_android.R
import com.thiagogalhardo.pokedex_android.domain.Pokemon
import com.thiagogalhardo.pokedex_android.viewmodel.PokemonViewModel
import com.thiagogalhardo.pokedex_android.viewmodel.PokemonViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    private val viewModel by lazy {
        ViewModelProvider(this, PokemonViewModelFactory())
            .get(PokemonViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.rvPokemons)


        viewModel.pokemons.observe(this, Observer {
            loadRecyclerView(it)

        })
    }

    private fun loadRecyclerView(pokemons: List<Pokemon?>) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PokemonAdapter(pokemons)

    }
}