package com.example.alfioesiea3a.presentation.api

data class PokemonDetailResponse (
    val types: List<Pokemonslot>,
    val name: String
)

data class Pokemonslot(
    val slot: Int,
    val type: PokemonType
)

data class PokemonType(
    val name: String,
    val url: String
)