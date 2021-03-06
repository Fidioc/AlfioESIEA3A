package com.example.alfioesiea3a.presentation.list

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alfioesiea3a.R
import com.example.alfioesiea3a.presentation.Singleton
import com.example.alfioesiea3a.presentation.api.PokeApi
import com.example.alfioesiea3a.presentation.api.PokemonListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PokemonListFragment : Fragment() {

    private lateinit var recyclerView : RecyclerView
    private val adapter = Pokemonadapter(listOf<Pokemon>(),::onClickedPokemon)
    private val sharedPref:SharedPreferences?=activity?.getSharedPreferences("app", Context.MODE_PRIVATE)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_pokemon_list,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.pokemon_recyclerview)
        recyclerView.apply {
            adapter = this@PokemonListFragment.adapter
            layoutManager = LinearLayoutManager(context)
        }


        callApi()
    }

    private fun callApi() {
        Singleton.pokeApi.getPokemonList().enqueue(object : Callback<PokemonListResponse> {
            override fun onResponse(
                call: Call<PokemonListResponse>,
                response: Response<PokemonListResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val pokemonResponse: PokemonListResponse = response.body()!!
                    showList(pokemonResponse.results)
                }
            }

            override fun onFailure(call: Call<PokemonListResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }



    private fun showList(pokeList: List<Pokemon>) {
        adapter.updateList(pokeList)
    }

    private fun onClickedPokemon(id: Int) {
        findNavController().navigate(R.id.navigateToPokemonDetailFragment, bundleOf(
            "pokemonId" to (id+1)
        ))
    }
    }

