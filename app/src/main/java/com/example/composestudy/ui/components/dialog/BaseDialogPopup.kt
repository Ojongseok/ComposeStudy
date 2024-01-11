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
import androidx.compose.ui.unit.dp
import com.example.composestudy.ui.components.dialog.components.button.DialogButtonsColumn
import com.example.composestudy.ui.components.dialog.components.content.DialogContentWrapper
import com.example.composestudy.ui.components.dialog.components.title.DialogTitleWrapper
import com.example.composestudy.ui.models.dialogs.DialogButton
import com.example.composestudy.ui.models.dialogs.DialogContent
import com.example.composestudy.ui.models.dialogs.DialogTitle

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
