package com.example.composestudy.ui.components.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composestudy.ui.components.dialog.components.button.DialogButtonsColumn
import com.example.composestudy.ui.components.dialog.components.content.DialogContentWrapper
import com.example.composestudy.ui.components.dialog.components.title.DialogTitleWrapper
import com.example.composestudy.ui.models.dialogs.DialogButton
import com.example.composestudy.ui.models.dialogs.DialogContent
import com.example.composestudy.ui.models.dialogs.DialogText
import com.example.composestudy.ui.models.dialogs.DialogTitle
import com.example.composestudy.ui.theme.ComposeStudyTheme

@Composable
fun BaseDialogPopup(
    dialogTitle: DialogTitle? = null,
    dialogContent: DialogContent? = null,
    buttons: List<DialogButton>? = null
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            dialogTitle?.let {
                DialogTitleWrapper(it)
            }
            Column(
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            ) {
                dialogContent?.let {
                    DialogContentWrapper(it)
                }
                buttons?.let {
                    DialogButtonsColumn(it)
                }
            }
        }
    }
}

@Preview
@Composable
fun BaseDialogPopupPreview() {
    ComposeStudyTheme {
        BaseDialogPopup(
            dialogTitle = DialogTitle.Header("헤더"),
            dialogContent = DialogContent.Large(
                DialogText.Default("디자인시스템을 엄청나게 활용중~~~디자인시스템을 엄청나게 활용중~~~디자인시스템을 엄청나게 활용중~~~")
            ),
            buttons = listOf(
                DialogButton.Primary("Okay") {

                }
            )
        )
    }
}

@Preview
@Composable
fun BaseDialogPopupPreview2() {
    ComposeStudyTheme {
        BaseDialogPopup(
            dialogTitle = DialogTitle.Large("라지헤더"),
            dialogContent = DialogContent.Default(
                DialogText.Default("디자인시스템을 엄청나게 활용중~~~디자인시스템을 엄청나게 활용중~~~디자인시스템을 엄청나게 활용중~~~")
            ),
            buttons = listOf(
                DialogButton.Secondary("확인") { },
                DialogButton.UnderlinedText("취소") { }
            )
        )
    }
}

@Preview
@Composable
fun BaseDialogPopupPreview3() {
    ComposeStudyTheme {
        BaseDialogPopup(
            dialogTitle = DialogTitle.Large("라지헤더"),
            dialogContent = DialogContent.Rating(
                DialogText.Rating(
                    text = "오종석",
                    rating = 3.5f
                )
            ),
            buttons = listOf(
                DialogButton.Primary("확인") { },
                DialogButton.Secondary("취소") { }
            )
        )
    }
}