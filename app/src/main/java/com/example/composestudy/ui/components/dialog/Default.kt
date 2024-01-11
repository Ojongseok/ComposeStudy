package com.example.composestudy.ui.components.dialog

import androidx.compose.runtime.Composable
import com.example.composestudy.ui.models.dialogs.DialogButton
import com.example.composestudy.ui.models.dialogs.DialogContent
import com.example.composestudy.ui.models.dialogs.DialogText
import com.example.composestudy.ui.models.dialogs.DialogTitle

@Composable
fun DialogPopup.Default(
    title: String,
    bodyText: String,
    buttons: List<DialogButton>
) {
    BaseDialogPopup(
        dialogTitle = DialogTitle.Default(title),
        dialogContent = DialogContent.Default(
            DialogText.Default(bodyText)
        ),
        buttons = buttons
    )
}