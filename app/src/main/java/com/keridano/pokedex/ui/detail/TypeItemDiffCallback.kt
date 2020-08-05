package com.keridano.pokedex.ui.detail

import androidx.recyclerview.widget.DiffUtil
import com.keridano.pokedex.model.PokemonType

class TypeItemDiffCallback(
    private val old: List<PokemonType>,
    private val new: List<PokemonType>
) : DiffUtil.Callback() {
    override fun getOldListSize() = old.size

    override fun getNewListSize() = new.size

    override fun areItemsTheSame(oldIndex: Int, newIndex: Int): Boolean {
        return old[oldIndex].type.name == new[newIndex].type.name
    }

    override fun areContentsTheSame(oldIndex: Int, newIndex: Int): Boolean {
        return old[oldIndex] == new[newIndex]
    }
}