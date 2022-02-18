package com.thiagogalhardo.pokedex_android.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thiagogalhardo.pokedex_android.R
import com.thiagogalhardo.pokedex_android.domain.Pokemon
import kotlinx.android.synthetic.main.pokemon_item.view.*

class PokemonAdapter(
    private val items: List<Pokemon?>
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items[position]
        holder.bindView(item)
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener() { v: View ->
                val position: Int = adapterPosition
                Toast.makeText(
                    itemView.context,
                    "Click in item ${position + 1}",
                    Toast.LENGTH_SHORT
                ).show()

                if (position == 0) {

                    Toast.makeText(
                        itemView.context,
                        "BINGO ${position + 1}",
                        Toast.LENGTH_SHORT
                    ).show()

                    val context = itemView.context
                    var mIntent = Intent(context, PokemonDetails::class.java)
                    context.startActivity(mIntent)


                    val bundle = Bundle()
                    bundle.putInt("positionId", position)
                    mIntent.putExtras(bundle)
                    context.startActivity(mIntent)
                }
            }
        }

        fun bindView(item: Pokemon?) = with(itemView) {
            val ivPokemon = findViewById<ImageView>(R.id.ivPokemon)
            val tvNumber = findViewById<TextView>(R.id.tvNumber)
            val tvName = findViewById<TextView>(R.id.tvName)
            val tvType1 = findViewById<TextView>(R.id.tvType1)
            val tvType2 = findViewById<TextView>(R.id.tvType2)

            item?.let {

                Glide.with(itemView.context).load(it.imageUrl).into(ivPokemon)

                tvNumber.text = "Nº ${item.formattedNumber}"
                tvName.text = item.name.capitalize()
                tvType1.text = item.types[0].name
                val backgroudCard = cv_pokemon


                when (tvType1.text) {

                    "normal" -> {
                        backgroudCard.setCardBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.normalType
                            )
                        )
                    }
                    "poison" -> {
                        backgroudCard.setCardBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.poisonType
                            )
                        )
                    }
                    "psychic" -> {
                        backgroudCard.setCardBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.psychicType
                            )
                        )
                    }
                    "grass" -> {
                        backgroudCard.setCardBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.grassType
                            )
                        )
                    }
                    "ground" -> {
                        backgroudCard.setCardBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.groundType
                            )
                        )
                    }
                    "ice" -> {
                        backgroudCard.setCardBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.iceType
                            )
                        )
                    }
                    "fire" -> {
                        backgroudCard.setCardBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.fireType
                            )
                        )
                    }
                    "rock" -> {
                        backgroudCard.setCardBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.rockType
                            )
                        )
                    }
                    "dragon" -> {
                        backgroudCard.setCardBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.dragonType
                            )
                        )
                    }
                    "water" -> {
                        backgroudCard.setCardBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.waterType
                            )
                        )
                    }
                    "bug" -> {
                        backgroudCard.setCardBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.bugType
                            )
                        )
                    }
                    "dark" -> {
                        backgroudCard.setCardBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.darkType
                            )
                        )
                    }
                    "fighting" -> {
                        backgroudCard.setCardBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.fightingType
                            )
                        )
                    }
                    "ghost" -> {
                        backgroudCard.setCardBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.ghostType
                            )
                        )
                    }
                    "steel" -> {
                        backgroudCard.setCardBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.steelType
                            )
                        )
                    }
                    "flying" -> {
                        backgroudCard.setCardBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.flyingType
                            )
                        )
                    }
                    "electric" -> {
                        backgroudCard.setCardBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.electricType
                            )
                        )
                    }
                    "fairy" -> {
                        backgroudCard.setCardBackgroundColor(
                            ContextCompat.getColor(
                                itemView.context,
                                R.color.fairyType
                            )
                        )
                    }
                }


                if (item.types.size > 1) {
                    tvType2.visibility = View.VISIBLE
                    tvType2.text = item.types[1].name
                } else {
                    tvType2.visibility = View.GONE
                }
            }
        }
    }
}
