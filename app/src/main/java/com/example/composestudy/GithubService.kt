package com.example.composestudy

import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("users/{user}/repos")
    suspend fun listRepos(
        @Path("user") user: String
    ): List<Repo>

}

data class Repo(
    val name: String
)