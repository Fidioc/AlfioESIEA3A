package com.example.alfioesiea3a.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alfioesiea3a.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PokemonListFragment : Fragment() {

    private lateinit var recyclerView : RecyclerView
    private val adapter = Pokemonadapter(listOf<String>())
    private val layourManager = LinearLayoutManager(context)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_pokemon_list,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         recyclerView= view.findViewById(R.id.pokemon_recyclerview)
        recyclerView.apply {
        adapter = this@PokemonListFragment.adapter
        layoutManager = this@PokemonListFragment.layourManager
        }
        val pokeList = arrayListOf<String>().apply {
            add("pikachu")
            add("salamèche")
            add("gobou")
        }
        adapter.updateList(pokeList)
        }
    }

