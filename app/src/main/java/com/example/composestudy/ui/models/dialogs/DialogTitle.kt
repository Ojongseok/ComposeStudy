package com.example.composestudy.ui.models.dialogs

sealed class DialogTitle(
    open val text: String
) {
    data class Default(
        override val text: String
    ) : DialogTitle(text)

    data class Header(
        override val text: String
    ) : DialogTitle(text)

    data class Large(
        override val text: String
    ) : DialogTitle(text)
}
