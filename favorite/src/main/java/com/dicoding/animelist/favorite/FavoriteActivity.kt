package com.dicoding.animelist.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.animelist.core.ui.AnimeListAdapter
import com.dicoding.animelist.detail.DetailActivity
import com.dicoding.animelist.favorite.databinding.ActivityFavoriteBinding
import com.dicoding.animelist.favorite.di.favoriteModule
import com.dicoding.animelist.favorite.viewmodel.FavoriteViewModel
import org.koin.core.context.loadKoinModules
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteActivity : AppCompatActivity() {

    private val viewModel: FavoriteViewModel by viewModel()
    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(favoriteModule)

        supportActionBar?.title = "Favorites"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        getFavoriteData()
    }

    private fun getFavoriteData(){
        val animeAdapter = AnimeListAdapter { selectedData ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        viewModel.animes.observe(this) { anime ->
            animeAdapter.setData(anime)
            binding.noDataIndicator.visibility =
                if (anime.isEmpty()) View.VISIBLE else View.GONE
        }

        with(binding.rvAnime) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = animeAdapter
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}