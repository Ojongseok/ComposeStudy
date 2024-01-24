package com.example.composestudy.ui.components.movie

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.example.composestudy.R
import com.example.composestudy.features.common.entity.MovieFeedItemEntity
import com.example.composestudy.features.feed.presentation.input.IFeedViewModelInput

private val CARD_WIDTH = 150.dp

@Composable
fun MovieItem(
    movie: MovieFeedItemEntity,
    input: IFeedViewModelInput
) {
    Column(
        modifier = Modifier
            .width(CARD_WIDTH)
            .padding(10.dp)
    ) {
        Poster(
            thumbnailMovie = movie,
            input = input
        )
        Text(
            text = movie.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(top = 11.dp)
        )
        Row(
            modifier = Modifier.padding(vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .padding(4.dp)
                    .size(12.dp),
                imageVector = ImageVector.vectorResource(R.drawable.ic_rating),
                contentDescription = "",
                tint = Color.Black.copy(
                    alpha = 0.5f
                )
            )
            Text(
                text = "${movie.rating}"
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Poster(
    thumbnailMovie: MovieFeedItemEntity,
    input: IFeedViewModelInput
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        onClick = {
            input.openDetail(thumbnailMovie.title)
        }
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest
                    .Builder(LocalContext.current)
                    .data(data = thumbnailMovie.thumbUrl)
                    .apply {
                        crossfade(true)
                        scale(Scale.FILL)
                    }.build()
            ),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillHeight
        )
    }
}

//@Preview
//@Composable
//fun MovieItemPreview() {
//    MovieItem()
//}