package com.dicoding.animelist.detail

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.dicoding.animelist.R
import com.dicoding.animelist.core.domain.model.Anime
import com.dicoding.animelist.databinding.ActivityDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.roundToInt

class DetailActivity : AppCompatActivity() {

    private val viewModel: DetailViewModel by viewModel()
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val anime = intent.getParcelableExtra<Anime>(EXTRA_DATA)
        setAnimeDetails(anime)
    }

    private fun setAnimeDetails(anime: Anime?) {
        anime?.let {
            supportActionBar?.title = it.title
            with(binding) {
                tvTitle.text = it.title
                tvSynopsis.text = it.synopsis
                tvEpisodes.text = getString(R.string.text_episode_template, it.episodes)
                tvSource.text = getString(R.string.text_source_template, it.source)
                tvType.text = getString(R.string.text_type_template, it.type)
                scoreBar.progress = (it.score.toDouble() * 10).roundToInt()
                scoreText.text = (it.score.toDouble() * 10).roundToInt().toString()

                Glide.with(this@DetailActivity)
                    .load(it.imageURL)
                    .into(imgPoster)
                imgPoster.setEdgeLength(200)
                imgPoster.setFadeDirection(FadingImageView.FadeSide.BOTTOM_SIDE)

                var statusFavorite = it.isFavorite
                setStatusFavorite(statusFavorite)
                fab.setOnClickListener {
                    statusFavorite = !statusFavorite
                    viewModel.setAnimeAsFavorite(anime, statusFavorite)
                    setStatusFavorite(statusFavorite)
                }
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_red))
            binding.fab.setColorFilter(R.color.Red)
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite))
            binding.fab.setColorFilter(R.color.DimGray)
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

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}