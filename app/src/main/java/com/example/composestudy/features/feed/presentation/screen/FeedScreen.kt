package com.example.composestudy.features.feed.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.composestudy.R
import com.example.composestudy.features.feed.presentation.input.IFeedViewModelInput
import com.example.composestudy.features.feed.presentation.output.FeedState
import com.example.composestudy.ui.components.movie.CategoryRow
import com.example.composestudy.ui.theme.Paddings
import timber.log.Timber

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedScreen(
    feedStateHolder: State<FeedState>,
    input: IFeedViewModelInput,
//    buttonColor: State<Color>,
    changeAppColor: () -> Unit
) {
//    val btnColor by remember { buttonColor }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.onBackground)
                    .requiredHeight(70.dp),
                title = {
                    Text(
                        modifier = Modifier.padding(
                            start = Paddings.medium
                        ),
                        text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.headlineMedium
                    )
                },
                actions = {
//                    AppBarMenu(
//                        btnColor = btnColor,
//                        changeAppColor = changeAppColor,
//                        input = input
//                    )
                }
            )
        }
    ) {
        BodyContent(
            feedState = feedStateHolder.value,
            input = input
        )
    }
}

@Composable
fun AppBarMenu(
    btnColor: Color,
    changeAppColor: () -> Unit,
    input: IFeedViewModelInput
) {
    Row(
        modifier = Modifier.padding(
            end = Paddings.large
        )
    ) {
        IconButton(
            onClick = {
                changeAppColor()
            }
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(color = btnColor)
            )
        }

        IconButton(
            onClick = {
                input.openInfoDialog()
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_information),
                contentDescription = "Information",
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Composable
fun BodyContent(
    feedState: FeedState,
    input: IFeedViewModelInput
) {
    when (feedState) {
        is FeedState.Loading -> {
            Timber.d("MoviesScreen: Loading")
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        is FeedState.Main -> {
            Timber.d("MoviesScreen: Success")
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                itemsIndexed(feedState.categories) { _, category ->
                    CategoryRow(
                        categoryEntity = category,
                        input = input
                    )
                }
            }
        }

        is FeedState.Failed -> {
            Timber.d("MoviesScreen: Error")
            RetryMessage(
                message = feedState.reason,
                input = input
            )
        }
    }
}

val IMAGE_SIZE = 48.dp

@Composable
fun RetryMessage(
    modifier: Modifier = Modifier,
    message: String,
    input: IFeedViewModelInput
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .requiredSize(IMAGE_SIZE),
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_warning),
            contentDescription = null
        )

        Text(
            text = message,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(
                top = Paddings.xlarge,
                bottom = Paddings.extra
            )
        )

        Button(
            onClick = { input.refreshFeed() }
        ) {
            Text("RETRY")
        }
    }
}