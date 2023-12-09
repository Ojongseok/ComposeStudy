package com.example.composestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
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
import androidx.compose.ui.unit.max
import com.example.composestudy.ui.theme.ComposeStudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeStudyTheme {
                Outer()
            }
        }
    }
}

@Composable
fun Outer() {
    Column {
        Inner(
            Modifier
            .widthIn(min = 100.dp, max = 350.dp)
            .heightIn(min = 20.dp, max = 200.dp)
        )
    }
}

@Composable
fun Inner(modifier: Modifier = Modifier) {
    BoxWithConstraints(
        modifier = modifier
    ) {
        if (maxHeight > 100.dp) {
            Text(
                text = "여기 꽤 길군요 ?",
                modifier = modifier.align(Alignment.BottomCenter)
            )
        }
        Text(
            text = "maxW: $maxWidth maxH: $maxHeight minW: $minWidth minH: $minHeight"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeStudyTheme {
        Outer()
    }
}