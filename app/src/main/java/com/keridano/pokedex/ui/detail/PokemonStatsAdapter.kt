package com.keridano.pokedex.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.keridano.pokedex.R
import com.keridano.pokedex.model.PokemonStat

class PokemonStatsAdapter(
) : Adapter<PokemonStatsAdapter.ViewHolder>() {

    private var pokemonStats = emptyList<PokemonStat>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemContainer = LayoutInflater.from(parent.context)
            .inflate(R.layout.pokemon_stat_item, parent, false) as ViewGroup
        return ViewHolder(itemContainer)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemonStatData = pokemonStats[position]
        holder.pokemonStatName.text = pokemonStatData.stat.name
        holder.pokemonBaseStat.text = pokemonStatData.baseStat.toString()
        holder.pokemonStatEffort.text = pokemonStatData.effort.toString()
    }

    override fun getItemCount() = pokemonStats.size

    fun updatePokemonStats(pokemonStats: List<PokemonStat>) {
        val diffResult = DiffUtil.calculateDiff(StatItemDiffCallback(this.pokemonStats, pokemonStats))
        this.pokemonStats = pokemonStats
        diffResult.dispatchUpdatesTo(this)
    }

    class ViewHolder(itemViewGroup: ViewGroup) : RecyclerView.ViewHolder(itemViewGroup) {
        val pokemonStatName: TextView = itemViewGroup.findViewById(R.id.statName)
        val pokemonBaseStat: TextView = itemViewGroup.findViewById(R.id.baseStat)
        val pokemonStatEffort: TextView = itemViewGroup.findViewById(R.id.effort)
    }
}