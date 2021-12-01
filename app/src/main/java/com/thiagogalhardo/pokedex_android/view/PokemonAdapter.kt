package com.thiagogalhardo.pokedex_android.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
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
                var backgroudCard = cv_pokemon




                if (tvType1.text.equals("normal")) {
                    backgroudCard.setCardBackgroundColor(resources.getColor(R.color.normalType))
                }
                if (tvType1.text.equals("poison")) {
                    backgroudCard.setCardBackgroundColor(resources.getColor(R.color.poisonType))
                }

                if (tvType1.text.equals("psychic")) {
                    backgroudCard.setCardBackgroundColor(resources.getColor(R.color.psychicType))
                }

                if (tvType1.text.equals("grass")) {
                    backgroudCard.setCardBackgroundColor(resources.getColor(R.color.grassType))
                }

                if (tvType1.text.equals("ground")) {
                    backgroudCard.setCardBackgroundColor(resources.getColor(R.color.groundType))
                }

                if (tvType1.text.equals("ice")) {
                    backgroudCard.setCardBackgroundColor(resources.getColor(R.color.iceType))
                }

                if (tvType1.text.equals("fire")) {
                    backgroudCard.setCardBackgroundColor(resources.getColor(R.color.fireType))
                }

                if (tvType1.text.equals("rock")) {
                    backgroudCard.setCardBackgroundColor(resources.getColor(R.color.rockType))
                }

                if (tvType1.text.equals("dragon")) {
                    backgroudCard.setCardBackgroundColor(resources.getColor(R.color.dragonType))
                }

                if (tvType1.text.equals("water")) {
                    backgroudCard.setCardBackgroundColor(resources.getColor(R.color.waterType))
                }


                if (tvType1.text.equals("bug")) {
                    backgroudCard.setCardBackgroundColor(resources.getColor(R.color.bugType))
                }


                if (tvType1.text.equals("dark")) {
                    backgroudCard.setCardBackgroundColor(resources.getColor(R.color.darkType))
                }

                if (tvType1.text.equals("fighting")) {
                    backgroudCard.setCardBackgroundColor(resources.getColor(R.color.fightingType))
                }

                if (tvType1.text.equals("ghost")) {
                    backgroudCard.setCardBackgroundColor(resources.getColor(R.color.ghostType))
                }

                if (tvType1.text.equals("steel")) {
                    backgroudCard.setCardBackgroundColor(resources.getColor(R.color.steelType))
                }

                if (tvType1.text.equals("flying")) {
                    backgroudCard.setCardBackgroundColor(resources.getColor(R.color.flyingType))
                }

                if (tvType1.text.equals("electric")) {
                    backgroudCard.setCardBackgroundColor(resources.getColor(R.color.electricType))
                }

                if (tvType1.text.equals("fairy")) {
                    backgroudCard.setCardBackgroundColor(resources.getColor(R.color.fairyType))
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
