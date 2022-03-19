package com.dicoding.animelist.core.utils

import androidx.recyclerview.widget.DiffUtil
import com.dicoding.animelist.core.domain.model.Anime

/**
 * Created by Seline on 09/03/2022 15:33
 */
class DiffHelper(
    private val oldList: List<Anime>,
    private val newList: List<Anime>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].animeId == newList[newItemPosition].animeId

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return compareContent(oldItem, newItem)
    }

    private fun compareContent(oldItem: Anime, newItem: Anime): Boolean {
        return (oldItem.animeId == newItem.animeId)
                && (oldItem.title == newItem.title)
                && (oldItem.synopsis == newItem.synopsis)
                && (oldItem.type == newItem.type)
                && (oldItem.score == newItem.score)
                && (oldItem.airedDate == newItem.airedDate)
                && (oldItem.imageURL == newItem.imageURL)
                && (oldItem.episodes == newItem.episodes)
                && (oldItem.source == newItem.source)

    }

}