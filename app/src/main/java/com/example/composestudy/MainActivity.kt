@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.composestudy

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
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
                    TopLevel()
                }
            }
        }
    }
}


class ToDoViewModel: ViewModel() {
    var text by mutableStateOf("")
    val toDoList = mutableStateListOf<ToDoData>()

//    val onSubmit: (String) -> Unit = {
//        val key = (toDoList.lastOrNull()?.key ?: 0) + 1
//        toDoList.add(ToDoData(key, it)).apply {
//            text = ""
//        }
//    }

    // 함수로 바꿔보기
    fun onSubmit(input: String) {
        val key = (toDoList.lastOrNull()?.key ?: 0) + 1
        toDoList.add(ToDoData(key, input)).apply {
            text = ""
        }
    }

    // MutableStateList는 element의 추가, 삭제, 변경되었을 때만 상태변경을 인식해 ui가 갱신된다.
    // 항목 하나의 값을 바꾸는 것보다 항목을 카피해서 인덱스에 다시 할당하는 방식으로 작성
    val onToggle: (Int, Boolean) -> Unit = { key, checked ->
        val i = toDoList.indexOfFirst {
            it.key == key
        }
        val newToDoList = toDoList[i].copy(done = checked)
        toDoList[i] = newToDoList
    }

    val onDelete: (Int) -> Unit = { key ->
        val i = toDoList.indexOfFirst { it.key == key }
        toDoList.removeAt(i)
    }

    val onEdit: (Int, String) -> Unit = { key, text ->
        val i = toDoList.indexOfFirst { it.key == key }
        toDoList[i] = toDoList[i].copy(text = text)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TopLevel(
    viewModel: ToDoViewModel = viewModel()
) {
//    val (text, setText) = remember { mutableStateOf("") }
//    val toDoList = remember { mutableStateListOf<ToDoData>() }

//    val onSubmit: (String) -> Unit = {
//        val key = (toDoList.lastOrNull()?.key ?: 0) + 1
//        toDoList.add(ToDoData(key, it)).apply {
//            viewModel.text = ""
//        }
//    }
//
//    // MutableStateList는 element의 추가, 삭제, 변경되었을 때만 상태변경을 인식해 ui가 갱신된다.
//    // 항목 하나의 값을 바꾸는 것보다 항목을 카피해서 인덱스에 다시 할당하는 방식으로 작성
//    val onToggle: (Int, Boolean) -> Unit = { key, checked ->
//        val i = toDoList.indexOfFirst {
//            it.key == key
//        }
//        val newToDoList = toDoList[i].copy(done = checked)
//        toDoList[i] = newToDoList
//    }
//
//    val onDelete: (Int) -> Unit = { key ->
//        val i = toDoList.indexOfFirst { it.key == key }
//        toDoList.removeAt(i)
//    }
//
//    val onEdit: (Int, String) -> Unit = { key, text ->
//        val i = toDoList.indexOfFirst { it.key == key }
//        toDoList[i] = toDoList[i].copy(text = text)
//    }

    Scaffold {
        Column {
            ToDoInput(
                text = viewModel.text,
                onTextChange = {
                   viewModel.text = it
                },
                onSubmit = {
                    viewModel.onSubmit(it)
                }
            )

            LazyColumn {
                items(viewModel.toDoList, key = { it.key}) {
                    Todo(
                        toDoData = it,
                        onToggle = viewModel.onToggle,
                        onDelete = viewModel.onDelete,
                        onEdit = viewModel.onEdit
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Todo(
    toDoData: ToDoData,
    onEdit: (key: Int, text: String) -> Unit = {_,_ ->},
    onToggle: (key: Int, checked: Boolean) -> Unit = {_,_ ->},
    onDelete: (key: Int) -> Unit = {}
) {
    var isEditing by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.padding(4.dp),
        elevation = CardDefaults.elevatedCardElevation(8.dp)
    ) {
        Crossfade(targetState = isEditing, label = "") {
            when(it) {
                false -> {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(
                            text = toDoData.text,
                            modifier = Modifier.weight(1f),
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1
                        )
                        Text(text = "완료")
                        Checkbox(
                            checked = toDoData.done,
                            onCheckedChange = { checked ->
                                onToggle(toDoData.key, checked)
                            }
                        )

                        Button(onClick = {
                            isEditing = true
                        }) {
                            Text(text = "수정")
                        }
                        Spacer(modifier = Modifier.size(4.dp))
                        Button(onClick = {
                            onDelete(toDoData.key)
                        }) {
                            Text(text = "삭제")
                        }
                    }
                }
                true -> {
                    var (newText, setNewText) = remember { mutableStateOf(toDoData.text) }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        OutlinedTextField(
                            value = newText,
                            onValueChange = setNewText,
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Button(onClick = {
                            onEdit(toDoData.key, newText)
                            isEditing = false
                        }) {
                            Text(text = "수정완료")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ToDoInput(
    text: String,
    onTextChange: (String) -> Unit,
    onSubmit: (String) -> Unit
) {
    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = onTextChange,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.size(8.dp))
        Button(onClick = {
            if (text.isNotBlank()) {
                onSubmit(text)
            }
        }) {
            Text(text = "입력")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeStudyTheme {
        TopLevel()
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoInputPreview() {
    ComposeStudyTheme {
        ToDoInput("테스트", {}, {})
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoPreview() {
    ComposeStudyTheme {
        Todo(toDoData = ToDoData(1,"테스트",true))
    }
}

data class ToDoData(
    val key: Int,
    val text: String,
    val done: Boolean = false
)