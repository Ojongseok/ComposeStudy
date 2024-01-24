package com.example.composestudy.features.detail.presentation.output

import com.example.composestudy.features.common.entity.MovieDetailEntity

sealed class MovieDetailState {
    object Initial : MovieDetailState()
    class Main(val movieDetailEntity: MovieDetailEntity) : MovieDetailState()
}
