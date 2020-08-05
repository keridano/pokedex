package com.keridano.pokedex.ui.detail

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.keridano.pokedex.R
import com.keridano.pokedex.model.Pokemon
import com.keridano.pokedex.utils.TAG
import kotlinx.android.synthetic.main.pokemon_detail.*
import org.koin.android.ext.android.inject

private const val POKEMON_ID = "pokemonId"

class PokemonDetailFragment : Fragment() {

    private val pokemonStatsRecyclerViewAdapter: PokemonStatsAdapter by inject()
    private val pokemonTypesRecyclerViewAdapter: PokemonTypesAdapter by inject()
    private val viewModel: PokemonDetailViewModel by inject()

    private val pokemonId by lazy {
        arguments?.getInt(POKEMON_ID)
            ?: throw IllegalArgumentException("pokemonId is required")
    }

    companion object {
        fun newInstance(id: Int): PokemonDetailFragment {
            val bundle = Bundle().apply {
                putInt(POKEMON_ID, id)
            }
            return PokemonDetailFragment().apply {
                arguments = bundle
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.pokemon_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        viewModel.observableState.observe(viewLifecycleOwner, Observer { state ->
            state?.let { renderState(state) }
        })

        if (savedInstanceState == null) {
            viewModel.dispatch(Action.LoadPokemonDetail(pokemonId))
        }
    }

    private fun setupRecyclerView() {
        pokemonStatsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        pokemonStatsRecyclerView.adapter = pokemonStatsRecyclerViewAdapter
        pokemonTypesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        pokemonTypesRecyclerView.adapter = pokemonTypesRecyclerViewAdapter
    }

    private fun renderState(state: State) {
        with(state) {
            when {
                isLoading -> renderLoadingState()
                isLoadError -> renderLoadPokemonDetailError()
                pokemon != null -> renderPokemonDetailState(pokemon)
            }
        }
    }

    private fun renderLoadingState() {
        loadingIndicator.visibility = View.VISIBLE
        pokemonNameTitleView.visibility = View.GONE
        pokemonNameView.visibility = View.GONE
        pokemonStatsTitleView.visibility = View.GONE
        pokemonImageView.visibility = View.GONE
        pokemonTypesTitleView.visibility = View.GONE
    }

    private fun renderPokemonDetailState(pokemon: Pokemon) {
        Log.d(TAG, pokemon.toString())

        loadingIndicator.visibility = View.GONE
        pokemonNameView.visibility = View.VISIBLE
        pokemonNameTitleView.visibility = View.VISIBLE
        pokemonStatsTitleView.visibility = View.VISIBLE
        pokemonImageView.visibility = View.VISIBLE
        pokemonTypesTitleView.visibility = View.VISIBLE

        pokemonNameView.text = pokemon.name
        GlideToVectorYou
            .init()
            .with(requireContext())
            .load(Uri.parse(pokemon.sprites.other.dreamWorld.frontDefault), pokemonImageView)
        pokemonStatsRecyclerViewAdapter.updatePokemonStats(pokemon.stats)
        pokemonTypesRecyclerViewAdapter.updatePokemonTypes(pokemon.types)
    }

    private fun renderLoadPokemonDetailError() {
        Toast.makeText(requireContext(), R.string.error_loading_data, Toast.LENGTH_LONG).show()
        pokemonNameTitleView.visibility = View.GONE
        pokemonNameView.visibility = View.GONE
        pokemonStatsTitleView.visibility = View.GONE
        pokemonImageView.visibility = View.GONE
        pokemonTypesTitleView.visibility = View.GONE
    }
}
