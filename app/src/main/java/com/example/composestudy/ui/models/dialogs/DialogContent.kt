package com.example.composestudy.ui.models.dialogs

sealed class DialogContent {
    data class Default(
        val dialogText: DialogText.Default
    ): DialogContent()

    data class Large(
        val dialogText: DialogText.Default
    ): DialogContent()

    data class Rating(
        val dialogText: DialogText.Rating
    ): DialogContent()
}
