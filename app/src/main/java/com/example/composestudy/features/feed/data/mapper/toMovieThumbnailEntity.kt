package com.example.composestudy.features.feed.data.mapper

import com.example.composestudy.features.common.entity.CategoryEntity
import com.example.composestudy.features.common.entity.MovieDetailEntity
import com.example.composestudy.features.common.entity.MovieFeedItemEntity
import com.example.composestudy.features.common.network.model.MovieResponse
import com.example.composestudy.features.feed.domain.enum.SortOrder

fun MovieResponse.toMovieDetailEntity(): MovieDetailEntity = MovieDetailEntity(
    actors = this.actors,
    desc = this.desc,
    directors = this.directors,
    genre = this.genre,
    imageUrl = this.imageUrl,
    thumbUrl = this.thumbUrl,
    imdbPath = this.imdbPath,
    title = this.title,
    rating = this.rating,
    year = this.year
)

fun MovieDetailEntity.toMovieThumbnailEntity(): MovieFeedItemEntity = MovieFeedItemEntity(
    genre = this.genre,
    thumbUrl = this.thumbUrl,
    title = this.title,
    rating = this.rating,
    year = this.year
)

fun List<MovieFeedItemEntity>.toCategoryList(sortOrder: SortOrder): List<CategoryEntity> {
    val movieList = this
    val genreSet = mutableSetOf<String>().apply {
        addAll(movieList.flatMap { it.genre })
    }

    return mutableListOf<CategoryEntity>().also { feedItems ->
        genreSet.forEachIndexed { index, genreName ->
            this
                .filter { it.genre.contains(genreName) }
                .sortedByDescending {
                    when (sortOrder) {
                        SortOrder.RATING -> it.rating
                        SortOrder.YEAR -> it.year?.toFloat()
                    }
                }
                .let {
                    feedItems.add(
                        CategoryEntity(
                            id = index,
                            genre = genreName,
                            movieFeedEntities = it
                        )
                    )
                }
        }
    }
}
