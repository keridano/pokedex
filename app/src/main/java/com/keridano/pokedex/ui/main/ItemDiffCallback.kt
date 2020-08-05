package com.keridano.pokedex.ui.main

import androidx.recyclerview.widget.DiffUtil
import com.keridano.pokedex.model.NamedApiResource

class ItemDiffCallback(
    private val old: List<NamedApiResource>,
    private val new: List<NamedApiResource>
) : DiffUtil.Callback() {
    override fun getOldListSize() = old.size

    override fun getNewListSize() = new.size

    override fun areItemsTheSame(oldIndex: Int, newIndex: Int): Boolean {
        return old[oldIndex].id == new[newIndex].id
    }

    override fun areContentsTheSame(oldIndex: Int, newIndex: Int): Boolean {
        return old[oldIndex] == new[newIndex]
    }
}