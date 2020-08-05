package com.keridano.pokedex.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.keridano.pokedex.R
import com.keridano.pokedex.model.NamedApiResource

typealias ClickListener = (NamedApiResource) -> Unit

class PokemonAdapter(
    private val clickListener: ClickListener
) : Adapter<PokemonAdapter.ViewHolder>() {

    private var pokemon = emptyList<NamedApiResource>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemContainer = LayoutInflater.from(parent.context)
            .inflate(R.layout.pokemon_item, parent, false) as ViewGroup
        val viewHolder = ViewHolder(itemContainer)
        itemContainer.setOnClickListener { clickListener(pokemon[viewHolder.adapterPosition]) }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemonData = pokemon[position]
        holder.pokemonId.text = pokemonData.id.toString()
        holder.pokemonName.text = pokemonData.name
    }

    override fun getItemCount() = pokemon.size

    fun updatePokemon(pokemon: List<NamedApiResource>) {
        val diffResult = DiffUtil.calculateDiff(ItemDiffCallback(this.pokemon, pokemon))
        this.pokemon = pokemon
        diffResult.dispatchUpdatesTo(this)
    }

    class ViewHolder(itemViewGroup: ViewGroup) : RecyclerView.ViewHolder(itemViewGroup) {
        val pokemonId: TextView = itemViewGroup.findViewById(R.id.pokemonId)
        val pokemonName: TextView = itemViewGroup.findViewById(R.id.pokemonName)
    }
}