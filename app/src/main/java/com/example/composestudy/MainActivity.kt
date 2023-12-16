package com.example.composestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
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
                    ConstraintLayoutEx()
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ConstraintLayoutEx(modifier: Modifier = Modifier) {
    Card (
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp),
        modifier = modifier.padding(8.dp)
    ) {
        ConstraintLayout(
            modifier = modifier.fillMaxWidth()
        ) {
            val (profileImage, author, desc) = createRefs()

            AsyncImage(
                model = "https://images.squarespace-cdn.com/content/v1/586ebc34d482e9c69268b69a/1624386831778-1123SHN1YH42IRMPMLQI/20201230172547741_X4PVBAOC.png?format=2500w",
                contentDescription = null,
                contentScale = ContentScale.Crop,
                placeholder = ColorPainter(color = Color.Green),
                modifier = modifier
                    .clip(CircleShape)
                    .size(52.dp)
                    .constrainAs(profileImage) {
//                        top.linkTo(parent.top)
//                        bottom.linkTo(parent.bottom)
                        centerVerticallyTo(parent)
                        start.linkTo(parent.start, margin = 8.dp)
                    }
            )

            Text(
                modifier = modifier
                    .constrainAs(author) {
                        linkTo(profileImage.end, parent.end, startMargin = 8.dp, endMargin = 8.dp)
                        width = Dimension.fillToConstraints
                    },
                text = "제목입니다."
            )

            Text(
                modifier = modifier.constrainAs(desc) {
                    linkTo(profileImage.end, parent.end, startMargin = 8.dp, endMargin = 8.dp)
                    width = Dimension.fillToConstraints
                },
                text = "내용내용입니다.내용내용입니다내용내용입니다내용내용입니다내용내용입니다내용내용입니다"
            )

            val chain = createVerticalChain(author, desc, chainStyle = ChainStyle.Packed)

            constrain(chain) {
                top.linkTo(parent.top, margin = 16.dp)
                bottom.linkTo(parent.bottom, margin = 16.dp)
            }
        }
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = modifier.padding(4.dp)
//        ) {
//            AsyncImage(
//                model = "https://images.squarespace-cdn.com/content/v1/586ebc34d482e9c69268b69a/1624386831778-1123SHN1YH42IRMPMLQI/20201230172547741_X4PVBAOC.png?format=2500w",
//                contentDescription = null,
//                contentScale = ContentScale.Crop,
//                placeholder = ColorPainter(color = Color.Green),
//                modifier = modifier
//                    .clip(CircleShape)
//                    .size(52.dp)
//            )
//
//            Column(
//                modifier = modifier.padding(start = 8.dp)
//            ) {
//                Text(text = "제목입니다.")
//                Spacer(modifier = modifier.size(4.dp))
//                Text(text = "내용내용입니다.")
//            }
//        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeStudyTheme {
        ConstraintLayoutEx()
    }
}
