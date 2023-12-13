package com.example.composestudy

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composestudy.ui.theme.ComposeStudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeStudyTheme {
                ScaffoldEx()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScaffoldEx() {
    var checked by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Image(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                },
                title = {
                    Text(text = "Scaffold App")
                }
            )
        }
    ) {
        Surface(
            modifier = Modifier.padding(8.dp)
        ) {
            CheckboxWithContent(
                checked = checked,
                toggleState = {
                    checked = !checked
                }
            ) {
                Text(text = "컴포즈를 좋아해요")
            }
        }
    }
}

@Composable
fun CheckboxWithContent(
    checked: Boolean,
    toggleState: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = Modifier.clickable {
            toggleState()
        },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = {
                toggleState()
            }
        )
        content()
    }
}

//@Composable
//fun SlotEx() {
//    var checked1 by remember { mutableStateOf(false) }
//    var checked2 by remember { mutableStateOf(false) }
//
//    Column {
//        CheckboxWithSlot(
//            checked = checked1,
//            onCheckedChanged = {
//                checked1 = !checked1
//            }
//        ) {
//            Text(text = "텍스트1", modifier = Modifier.align(Alignment.CenterVertically))
//        }
//
//        CheckboxWithSlot(
//            checked = checked2,
//            onCheckedChanged = {
//                checked2 = !checked2
//            }
//        ) {
//            Text(text = "텍스트2", modifier = Modifier.align(Alignment.CenterVertically))
//        }
//    }
//}
//
//@Composable
//fun CheckboxWithSlot(
//    checked: Boolean,
//    onCheckedChanged: () -> Unit,
//    content: @Composable RowScope.() -> Unit
//) {
//    Row(
//        modifier = Modifier.clickable {
//            onCheckedChanged()
//        },
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Checkbox(
//            checked = checked,
//            onCheckedChange = {
//                onCheckedChanged()
//            }
//        )
//        content()
//    }
//}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeStudyTheme {
        ScaffoldEx()
    }
}