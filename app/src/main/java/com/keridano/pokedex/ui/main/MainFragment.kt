package com.keridano.pokedex.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.keridano.pokedex.R
import com.keridano.pokedex.model.NamedApiResource
import com.keridano.pokedex.model.NamedApiResourceList
import com.keridano.pokedex.ui.detail.PokemonDetailFragment
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.android.ext.android.inject

class MainFragment : Fragment() {

    private val clickListener: ClickListener = this::onPokemonClicked

    private val recyclerViewAdapter = PokemonAdapter(clickListener)

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecyclerView()

        viewModel.observableState.observe(viewLifecycleOwner, Observer { state ->
            state?.let { renderState(state) }
        })

        viewModel.dispatch(Action.LoadPokemonData)
    }

    private fun renderState(state: State) {
        with(state) {
            when {
                isLoading -> renderLoadingState()
                isError -> renderErrorState()
                else -> renderPokemonState(pokemon)
            }
        }
    }

    private fun renderLoadingState() {
        loadingIndicator.visibility = View.VISIBLE
    }

    private fun renderErrorState() {
        loadingIndicator.visibility = View.GONE
        Toast.makeText(requireContext(), R.string.error_loading_data, Toast.LENGTH_LONG).show()
    }

    private fun renderPokemonState(pokemonList: NamedApiResourceList) {
        loadingIndicator.visibility = View.GONE
        recyclerViewAdapter.updatePokemon(pokemonList.results)
        pokemonRecyclerView.visibility = View.VISIBLE
    }

    private fun setupRecyclerView() {
        pokemonRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        pokemonRecyclerView.adapter = recyclerViewAdapter
        pokemonRecyclerView.setHasFixedSize(true)
    }

    private fun onPokemonClicked(pokemon: NamedApiResource) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, PokemonDetailFragment.newInstance(pokemon.id))
            .addToBackStack(null)
            .commit()
    }

}