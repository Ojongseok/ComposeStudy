package com.example.composestudy.ui.components.dialog

import androidx.compose.runtime.Composable
import com.example.composestudy.ui.models.dialogs.DialogButton
import com.example.composestudy.ui.models.dialogs.DialogContent
import com.example.composestudy.ui.models.dialogs.DialogText
import com.example.composestudy.ui.models.dialogs.DialogTitle

object DialogPopup

@Composable
fun DialogPopup.Alert(
    title: String,
    bodyText: String,
    buttons: List<DialogButton>
) {
    BaseDialogPopup(
        dialogTitle = DialogTitle.Header(title),
        dialogContent = DialogContent.Large(
            DialogText.Default(bodyText)
        ),
        buttons = buttons
    )
}