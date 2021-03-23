package com.thiagogalhardo.pokedex_android.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thiagogalhardo.pokedex_android.R
import com.thiagogalhardo.pokedex_android.api.PokemonRepository
import com.thiagogalhardo.pokedex_android.domain.Pokemon

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.rvPokemons)
/*
        val charmander = Pokemon(
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png",
            1,
            "Charmander",
            listOf(
                PokemonType("Fire")
            )
        )
        val pokemons = listOf(charmander, charmander, charmander, charmander, charmander)


 */
        Thread(Runnable {
            loadPokemons()
        }).start()

    }

    private fun loadPokemons() {
        val pokemonsApiResult = PokemonRepository.listPokemons()

        pokemonsApiResult?.results?.let {

            val pokemons: List<Pokemon?> = it.map { pokemonResult ->
                val number = pokemonResult.url
                    .replace("https://pokeapi.co/api/v2/pokemon/", "")
                    .replace("/", "").toInt()

                val pokemonApiResult = PokemonRepository.getPokemon(number)

                pokemonApiResult?.let {

                    Pokemon(
                        pokemonApiResult.id,
                        pokemonApiResult.name,
                        pokemonApiResult.types.map { type ->

                            type.type

                        }
                    )
                }


            }


            val layoutManager = LinearLayoutManager(this)

            recyclerView.post {
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = PokemonAdapter(pokemons)
            }


        }

    }
}