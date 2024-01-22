package com.example.composestudy.features.feed.presentation.output

sealed class FeedState {
    object Loading: FeedState()

    class Main(
        val movieList: List<MovieFeedEntity>
    ): FeedState()

    class Failed(
        val reason: String
    ): FeedState()
}