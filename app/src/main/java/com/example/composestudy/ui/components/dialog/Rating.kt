package com.example.composestudy.ui.components.dialog

import androidx.compose.runtime.Composable
import com.example.composestudy.ui.models.dialogs.DialogButton
import com.example.composestudy.ui.models.dialogs.DialogContent
import com.example.composestudy.ui.models.dialogs.DialogText
import com.example.composestudy.ui.models.dialogs.DialogTitle

@Composable
fun DialogPopup.Rating(
    movieName: String,
    rating: Float,
    buttons: List<DialogButton>
) {
    BaseDialogPopup(
        dialogTitle = DialogTitle.Large("Movie Lating!"),
        dialogContent = DialogContent.Rating(
            DialogText.Rating(
                text = movieName,
                rating = rating
            )
        ),
        buttons = buttons
    )
}