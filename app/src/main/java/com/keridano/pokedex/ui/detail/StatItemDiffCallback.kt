package com.keridano.pokedex.ui.detail

import androidx.recyclerview.widget.DiffUtil
import com.keridano.pokedex.model.PokemonStat

class StatItemDiffCallback(
    private val old: List<PokemonStat>,
    private val new: List<PokemonStat>
) : DiffUtil.Callback() {
    override fun getOldListSize() = old.size

    override fun getNewListSize() = new.size

    override fun areItemsTheSame(oldIndex: Int, newIndex: Int): Boolean {
        return old[oldIndex].stat.name == new[newIndex].stat.name
    }

    override fun areContentsTheSame(oldIndex: Int, newIndex: Int): Boolean {
        return old[oldIndex] == new[newIndex]
    }
}