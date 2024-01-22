package com.example.composestudy.features.feed.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composestudy.features.common.repository.MovieRepository
import com.example.composestudy.features.feed.presentation.input.IFeedViewModelInput
import com.example.composestudy.features.feed.presentation.output.FeedState
import com.example.composestudy.features.feed.presentation.output.FeedUiEffect
import com.example.composestudy.features.feed.presentation.output.IFeedViewModelOutput
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val movieRepository: MovieRepository
): ViewModel(), IFeedViewModelInput, IFeedViewModelOutput {

    // 화면에 보여주기 위한 Flow
    private val _feedState: MutableStateFlow<FeedState> = MutableStateFlow(FeedState.Loading)
    override val feedState: StateFlow<FeedState> get() = _feedState

    private val _feedUiEffect = MutableSharedFlow<FeedUiEffect>(replay = 0)
    override val feedUiEffect: SharedFlow<FeedUiEffect> get() = feedUiEffect

    // 유저로부터 입력을 받아 Fragment 단에서 액션을 수행하기 위한 Flow
    val feedUiState: SharedFlow<FeedUiEffect> get() = _feedUiEffect

    fun getMovies() {
        viewModelScope.launch {
            movieRepository.getMovieList()
        }
    }

    override fun openDetail(movieName: String) {
        TODO("Not yet implemented")
    }

    override fun openInfoDialog() {
        TODO("Not yet implemented")
    }

    override fun refreshFeed() {
        TODO("Not yet implemented")
    }
}