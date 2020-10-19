package com.example.arkanittestapp

import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<DataUsers>

    @GET("posts")
    suspend fun getPosts(): List<DataPost>
}