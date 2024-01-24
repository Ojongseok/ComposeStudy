package com.example.composestudy.ui.components.movie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composestudy.features.common.entity.CategoryEntity
import com.example.composestudy.features.feed.presentation.input.IFeedViewModelInput

@Composable
fun CategoryRow(
    categoryEntity: CategoryEntity,
    input: IFeedViewModelInput
) {
    Column {
        CategoryTitle(categoryEntity.genre)
        LazyRow(
            contentPadding = PaddingValues(horizontal = 10.dp)
        ) {
            itemsIndexed(categoryEntity.movieFeedEntities) {_, item ->
                MovieItem(
                    movie = item,
                    input = input
                )
            }
        }
    }
}

@Composable
fun CategoryTitle(title: String) {
    Text(
        text = title,
        modifier = Modifier.padding(10.dp)
    )
}

//@Preview
//@Composable
//fun CategoryRowPreview() {
//    CategoryRow()
//}
