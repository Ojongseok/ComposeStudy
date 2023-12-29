package com.example.composestudy

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items

@Composable
fun MainScreen(
    onPokemonClick: (String) -> Unit,
    viewModel: PokemonViewModel = hiltViewModel()
) {
    val items = viewModel.pokemonList.collectAsLazyPagingItems()

    LazyColumn {
        items(items, key = { it.url }) {
            it?.let {
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxSize(),
                    elevation = CardDefaults.elevatedCardElevation(8.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column{
                            Text(text = "포켓몬: ${it.name}")
                            Text(
                                text = it.url,
                                modifier = Modifier.alpha(0.4f)
                            )
                        }
                        Spacer(modifier = Modifier.size(16.dp))
                        Button(
                            onClick = {
                                onPokemonClick(it.url)
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "보기")
                        }
                    }
                }
            }
        }
    }
}