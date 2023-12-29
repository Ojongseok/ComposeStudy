package com.example.composestudy

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage

@Composable
fun DetailScreen(
    pokemonId: Int,
    onPokemonClick: () -> Unit,
    viewModel: PokemonViewModel = hiltViewModel()
) {
    viewModel.getPokemon(pokemonId)

    Card(
        modifier = Modifier.padding(8.dp),
        elevation = CardDefaults.elevatedCardElevation(8.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(8.dp)
        ) {
            val result = viewModel.pokemonResult
            val pokemonName = result.species.name

            Text(text = pokemonName, fontSize = 24.sp)

            AsyncImage(
                model = result.sprites.frontDefault,
                contentDescription = pokemonName,
                modifier = Modifier.size(300.dp)
            )
            Button(onClick = onPokemonClick, modifier = Modifier.fillMaxWidth()) {
                Text(text = "뒤로")
            }
        }
    }
}