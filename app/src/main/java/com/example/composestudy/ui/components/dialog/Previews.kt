package com.example.composestudy.ui.components.dialog

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composestudy.R
import com.example.composestudy.ui.models.buttons.LeadingIconData
import com.example.composestudy.ui.models.dialogs.DialogButton
import com.example.composestudy.ui.theme.ComposeStudyTheme

@Preview
@Composable
fun AlertPreview() {
    ComposeStudyTheme {
        DialogPopup.Alert(
            title = "Title",
            bodyText = "blah balh blah",
            buttons = listOf(
                DialogButton.UnderlinedText("Okay") {}
            )
        )
    }
}

@Preview
@Composable
fun DefaultPreview() {
    ComposeStudyTheme {
        DialogPopup.Default(
            title = "Title",
            bodyText = "blah balh blah",
            buttons = listOf(
                DialogButton.Primary("OPEN") {},
                DialogButton.SecondaryBorderless("CANCEL") {}
            )
        )
    }
}

@Preview
@Composable
fun RatingPreview() {
    ComposeStudyTheme {
        DialogPopup.Rating(
            movieName = "The Lord of the Rings: The Two Towers",
            rating = 7.5f,
            buttons = listOf(
                DialogButton.Primary(
                    title = "OPEN",
                    leadingIconData = LeadingIconData(
                        iconDrawable = R.drawable.ic_send,
                        iconContentDescription = null
                    )
                ) {},
                DialogButton.SecondaryBorderless("CANCEL") {}
            )
        )
    }
}
