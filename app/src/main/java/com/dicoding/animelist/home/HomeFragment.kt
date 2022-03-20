package com.dicoding.animelist.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.animelist.R
import com.dicoding.animelist.core.data.Resource
import com.dicoding.animelist.core.ui.AnimeListAdapter
import com.dicoding.animelist.databinding.FragmentHomeBinding
import com.dicoding.animelist.detail.DetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val animeAdapter = AnimeListAdapter { selectedData ->
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            homeViewModel.animes.observe(viewLifecycleOwner) { anime ->
                if (anime != null) {
                    when (anime) {
                        is Resource.Loading -> binding.progBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progBar.visibility = View.GONE
                            animeAdapter.setData(anime.data)
                            binding.noDataIndicator.visibility =
                                if (anime.data?.isEmpty() == false) View.GONE else View.VISIBLE
                        }
                        is Resource.Error -> {
                            binding.progBar.visibility = View.GONE
                            Toast.makeText(requireContext(), R.string.text_error, Toast.LENGTH_LONG)
                                .show()
                        }
                    }
                }
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