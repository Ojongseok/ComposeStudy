@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.composestudy

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.example.composestudy.ui.theme.ComposeStudyTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeStudyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AnimationEx()
                }
            }
        }
    }
}

@Composable
fun AnimationEx() {
    var isDarkMode by remember { mutableStateOf(false) }

    val transition = updateTransition(targetState = isDarkMode, label = "다크모드 관리")

    val backgroundColor by transition.animateColor(label = "") {
        when(it) {
            true -> Color.Black
            false -> Color.White
        }
    }

    val color by transition.animateColor(label = "") {
        when(it) {
            true -> Color.White
            false -> Color.Black
        }
    }

    val alpha by transition.animateFloat(label = "") {
        when(it) {
            true -> 0.5f
            false -> 1.0f
        }
    }

    Column(
        modifier = Modifier
            .background(backgroundColor)
            .alpha(alpha)
    ) {
        RadioButtonWithText(text = "일반 모드", color = color, selected = !isDarkMode) {
            isDarkMode = false
        }
        RadioButtonWithText(text = "다크 모드", color = color, selected = isDarkMode) {
            isDarkMode = true
        }

//        Row {
//            Box(
//                modifier = Modifier
//                    .background(Color.Red)
//                    .size(20.dp),
//                contentAlignment = Alignment.Center
//            ) {
//                Text(text = "1", color = Color.White)
//            }
//            Box(
//                modifier = Modifier
//                    .background(Color.Green)
//                    .size(20.dp),
//                contentAlignment = Alignment.Center
//            ) {
//                Text(text = "2", color = Color.White)
//            }
//            Box(
//                modifier = Modifier
//                    .background(Color.Magenta)
//                    .size(20.dp),
//                contentAlignment = Alignment.Center
//            ) {
//                Text(text = "3", color = Color.White)
//            }
//        }
        Crossfade(targetState = isDarkMode, label = "") {
            when(it) {
                true -> {
                    Row {
                        Box(
                            modifier = Modifier
                                .background(Color.Red)
                                .size(20.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "1", color = Color.White)
                        }
                        Box(
                            modifier = Modifier
                                .background(Color.Green)
                                .size(20.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "2", color = Color.White)
                        }
                        Box(
                            modifier = Modifier
                                .background(Color.Magenta)
                                .size(20.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "3", color = Color.White)
                        }
                    }
                }
                false -> {
                    Column {
                        Box(
                            modifier = Modifier
                                .background(Color.Red)
                                .size(20.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "a", color = Color.White)
                        }
                        Box(
                            modifier = Modifier
                                .background(Color.Green)
                                .size(20.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "b", color = Color.White)
                        }
                        Box(
                            modifier = Modifier
                                .background(Color.Magenta)
                                .size(20.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "c", color = Color.White)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RadioButtonWithText(
    text: String,
    color: Color = Color.Black,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.selectable(
            selected = selected,
            onClick = onClick
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick
        )
        Text(
            text = text,
            color = color
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeStudyTheme {
        AnimationEx()
    }
}

@Preview(showBackground = true)
@Composable
fun RadioButtonWithTextPreview() {
    ComposeStudyTheme {
        RadioButtonWithText(
            text = "라디오 버튼",
            color = Color.Red,
            selected = true,
            onClick = {}
        )
    }
}