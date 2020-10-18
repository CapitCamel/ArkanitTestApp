package com.example.arkanittestapp

import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users")
    fun getUsers(): Deferred<List<DataUsers>>

    @GET("posts")
    fun getPosts(): Deferred<List<DataPost>>
}