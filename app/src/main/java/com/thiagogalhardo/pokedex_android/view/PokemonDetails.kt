package com.thiagogalhardo.pokedex_android.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.thiagogalhardo.pokedex_android.R

open class PokemonDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)
        val tvNumber = findViewById<TextView>(R.id.tvNumber1D)

        val bundle = intent.extras
        val id = bundle?.getInt("positionId")


        tvNumber.text = "num " + id.toString()

    }
}

