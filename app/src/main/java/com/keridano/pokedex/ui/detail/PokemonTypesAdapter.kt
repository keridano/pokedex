package com.keridano.pokedex.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.keridano.pokedex.R
import com.keridano.pokedex.model.PokemonType

class PokemonTypesAdapter(
) : Adapter<PokemonTypesAdapter.ViewHolder>() {

    private var pokemonTypes = emptyList<PokemonType>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemContainer = LayoutInflater.from(parent.context)
            .inflate(R.layout.pokemon_type_item, parent, false) as ViewGroup
        return ViewHolder(itemContainer)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemonTypeData = pokemonTypes[position]
        holder.pokemonTypeName.text = pokemonTypeData.type.name
    }

    override fun getItemCount() = pokemonTypes.size

    fun updatePokemonTypes(pokemonTypes: List<PokemonType>) {
        val diffResult = DiffUtil.calculateDiff(TypeItemDiffCallback(this.pokemonTypes, pokemonTypes))
        this.pokemonTypes = pokemonTypes
        diffResult.dispatchUpdatesTo(this)
    }

    class ViewHolder(itemViewGroup: ViewGroup) : RecyclerView.ViewHolder(itemViewGroup) {
        val pokemonTypeName: TextView = itemViewGroup.findViewById(R.id.typeName)
    }
}