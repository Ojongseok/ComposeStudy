package com.example.composestudy.ui.components.movie

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composestudy.R

private val CARD_WIDTH = 150.dp

@Composable
fun MovieItem() {
    Column(
        modifier = Modifier
            .width(CARD_WIDTH)
            .padding(10.dp)
    ) {
        Poster(
            modifier = Modifier
                .width(CARD_WIDTH)
        )
        Text(
            text = "The Lord the Ring 1",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(top = 11.dp)
        )
        Row(
            modifier = Modifier.padding(vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.padding(4.dp).size(12.dp),
                imageVector = ImageVector.vectorResource(R.drawable.ic_rating),
                contentDescription = "",
                tint = Color.Black.copy(
                    alpha = 0.5f
                )
            )
            Text(
                text = "5.0"
            )
        }
    }
}

@Composable
fun Poster(
    modifier: Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Box(
            modifier = modifier.background(Color.Blue)
        )
    }
}

@Preview
@Composable
fun MovieItemPreview() {
    MovieItem()
}