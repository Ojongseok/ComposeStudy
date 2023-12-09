package com.example.composestudy

import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composestudy.ui.theme.ComposeStudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeStudyTheme {
                ButtonExample(
                    onButtonClicked = {
                        Toast.makeText(this, "터치터치", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }
}

@Composable
fun ButtonExample(
    onButtonClicked: () -> Unit
) {
    Button(
        onClick = onButtonClicked,
        enabled = true,
//        border = BorderStroke(4.dp, Color.Magenta),
        shape = RoundedCornerShape(12.dp),
        contentPadding = PaddingValues(16.dp, 4.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Send,
            contentDescription = "Send"
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing)
        )
        Text(text = "Send")
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        modifier = Modifier
//            .width(300.dp)
//            .height(200.dp),
//        text = "Helloooooo ${name}!\nHello ${name}!\nHello ${name}!",
//        color = Color.Blue,
//        fontSize = 24.sp,
//        fontWeight = FontWeight.Bold,
//        fontFamily = FontFamily.SansSerif,
//        maxLines = 2,
//        textDecoration = TextDecoration.Underline,
//        textAlign = TextAlign.Center
//    )
//}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeStudyTheme {
        ButtonExample(onButtonClicked = {})
    }
}