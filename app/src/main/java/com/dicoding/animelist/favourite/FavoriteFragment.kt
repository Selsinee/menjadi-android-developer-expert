package com.dicoding.animelist.favourite

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.animelist.core.ui.AnimeListAdapter
import com.dicoding.animelist.databinding.FragmentFavoriteBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val animeAdapter = AnimeListAdapter { selectedData ->
                Log.d("<TAG>", "detail")
//                val intent = Intent(activity, DetailTourismActivity::class.java)
//                intent.putExtra(DetailTourismActivity.EXTRA_DATA, selectedData)
//                startActivity(intent)

            }

            favoriteViewModel.animes.observe(viewLifecycleOwner) { anime ->
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

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}