@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.composestudy

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
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
                    PyeongToSquareMeter()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PyeongToSquareMeter() {
    var pyeong by rememberSaveable { mutableStateOf("") }
    var squareMeter by rememberSaveable { mutableStateOf("") }
//    Column(
//        modifier = Modifier.padding(16.dp)
//    ) {
//        OutlinedTextField(
//            value = pyeong,
//            onValueChange = {
//                if (it.isBlank()) {
//                    pyeong = ""
//                }
//                val numericValue = it.toFloatOrNull() ?: return@OutlinedTextField
//                pyeong = it
//
//                squareMeter = (numericValue*3.306).toString()
//            },
//            label = {
//                Text(text = "평")
//            }
//        )
//        OutlinedTextField(
//            value = squareMeter,
//            onValueChange = {
//
//            },
//            label = {
//                Text(text = "제곱미터")
//            }
//        )
//    }

    PyeongToSquareMeterStateless(
        pyeong = pyeong,
        squareMeter = squareMeter,
        onPyeongChange = {
            if (it.isBlank()) {
                pyeong = ""
                squareMeter = ""
                return@PyeongToSquareMeterStateless
            }
            val numericValue = it.toFloatOrNull() ?: return@PyeongToSquareMeterStateless
            pyeong = it

            squareMeter = (numericValue*3.306).toString()
        }
    )
}

// Step2 -> 상태를 관리하는 범위를 좁히기 위한 State 호스팅 방식으로 작성
@Composable
fun PyeongToSquareMeterStateless(
    pyeong: String,
    squareMeter: String,
    onPyeongChange: (String) -> Unit
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        OutlinedTextField(
            value = pyeong,
            onValueChange = onPyeongChange,
            label = {
                Text(text = "평")
            }
        )
        OutlinedTextField(
            value = squareMeter,
            onValueChange = { },
            label = {
                Text(text = "제곱미터")
            }
        )
    }
}


@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeStudyTheme {
        PyeongToSquareMeter()
    }
}
