package com.example.composestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composestudy.ui.theme.ComposeStudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeStudyTheme {
                ColumnEx()
            }
        }
    }
}

@Composable
fun ColumnEx() {
    Column(
        modifier = Modifier.size(120.dp),
        horizontalAlignment = Alignment.End
    ) {
        Text(
            text = "첫번째!",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(text = "두번째!")
        Text(
            text = "세번째!",
            modifier = Modifier.align(Alignment.Start)
        )
    }
}

//@Composable
//fun RowEx() {
//    Row(
//        modifier = Modifier.size(200.dp, 40.dp),
//        verticalAlignment = Alignment.Bottom,
//        horizontalArrangement = Arrangement.SpaceBetween
//    ) {
//        Text(
//            text = "첫번째 !!",
//            modifier = Modifier
//                .align(Alignment.Top)
//                .weight(2f)
//                .background(Color.Magenta),
//            textAlign = TextAlign.End
//        )
//        Icon(
//            modifier = Modifier
//                .weight(1f)
//                .background(Color.Cyan),
//            imageVector = Icons.Filled.Add,
//            contentDescription = null
//        )
//        Text(
//            modifier = Modifier
//                .weight(3f)
//                .background(Color.Yellow),
//            text = "세번째 !!",
//            textAlign = TextAlign.Center
//        )
//    }
//}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeStudyTheme {
        ColumnEx()
    }
}