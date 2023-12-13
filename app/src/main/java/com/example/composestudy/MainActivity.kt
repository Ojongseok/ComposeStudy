package com.example.composestudy

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composestudy.ui.theme.ComposeStudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeStudyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyColumnEx(itemList = items)
                }
            }
        }
    }
}

@Composable
fun LazyColumnEx(itemList: List<ItemData>) {
    LazyColumn {
        items(itemList) {item ->
            Item(itemData = item)
        }
    }
}

@Composable
fun Item(itemData: ItemData) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = itemData.imageId),
                contentDescription = null
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = itemData.title,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = itemData.description,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Light
            )
        }
    }
}

data class ItemData(
    @DrawableRes val imageId: Int,
    val title: String,
    val description: String
)

@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    ComposeStudyTheme {
        Item(
            ItemData(
                imageId = R.drawable.image_grand_canyon,
                title = "해변 놀이 공원",
                description = "해변 놀이 공원 설명입니다. 해변 놀아놀이놀이 설명이야 루루룰ㄹ룰ㄹ\n해변 놀이 공원 설명입니다. 해변 놀아놀이놀이 설명이야 루루룰ㄹ룰ㄹ"
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeStudyTheme {
        LazyColumnEx(itemList = items)
    }
}

val items = listOf(
    ItemData(
        imageId = R.drawable.image_grand_canyon,
        title = "해변 놀이 공원1",
        description = "해1111변 놀이11 공원 설명입니다. 해변 놀아놀이놀이 설명이야 루루룰ㄹ룰ㄹ\n해변 놀이 공원 설명입니다. 해변 놀아놀이놀이 설명이야 루루룰ㄹ룰ㄹ"
    ),
    ItemData(
        imageId = R.drawable.image_grand_canyon,
        title = "해변 놀이 공원2",
        description = "해변 놀이 공원 설명입니다. 해변 놀아놀이놀이 설명이야222222 루루룰ㄹ룰ㄹ\n해변 놀이 공원 설명입니다. 해변 놀아놀이놀이 설명이야 루루룰ㄹ룰ㄹ"
    ),ItemData(
        imageId = R.drawable.image_grand_canyon,
        title = "해변 놀이 공원3",
        description = "해변 놀이 공원 설명33333입니다. 해변 놀아놀이놀이 설명이야 루루룰ㄹ룰ㄹ\n해변 놀이 공원 설명입니다. 해변 놀아놀이놀이 설명이야 루루룰ㄹ룰ㄹ"
    ),
    ItemData(
        imageId = R.drawable.image_grand_canyon,
        title = "해변 놀이 공원4",
        description = "해변 놀이 공원 설명입니444444444다. 해변 놀아놀이놀이 설명이야 루루룰ㄹ룰ㄹ\n해변 놀이 공원 설명입니다. 해변 놀아놀이놀이 설명이야 루루룰ㄹ룰ㄹ"
    ),
    ItemData(
        imageId = R.drawable.image_grand_canyon,
        title = "해변 놀이 공원5",
        description = "해변 5555555놀이 공원 설명입니다. 해변 놀아놀이놀이 설명이야 루루룰ㄹ룰ㄹ\n해변 놀이 공원 설명입니다. 해변 놀아놀이놀이 설명이야 루루룰ㄹ룰ㄹ"
    )
)