package com.example.animelist.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.animelist.R
import com.example.animelist.core.domain.model.Anime
import com.example.animelist.core.utils.DiffHelper
import com.example.animelist.databinding.ItemAnimeBinding

/**
 * Created by Seline on 09/03/2022 15:17
 */
class AnimeListAdapter(private val onClick: (id: String) -> Unit) :
    RecyclerView.Adapter<AnimeListAdapter.ListViewHolder>() {

    private var listData = ArrayList<Anime>()

    fun setData(newListData: List<Anime>?) {
        if (newListData == null) return
        val diffUtil = DiffHelper(listData, newListData)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        listData.clear()
        listData.addAll(newListData)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_anime, parent, false)
        )

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemAnimeBinding.bind(itemView)
        fun bind(data: Anime) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.imageURL)
                    .into(imgPoster)
                textTitle.text = data.title
                textType.text = data.type
                itemView.setOnClickListener { onClick(data.animeId) }
            }
        }
    }

}
