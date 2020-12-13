package com.jokesapp.service

import com.jokesapp.model.Category
import com.jokesapp.model.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisInterface {

    @GET("/jokes/categories")
    fun listJokes(): Call<List<Category>>

    @GET("/jokes/search")
    fun listByText(@Query("query") query : String): Call<Response>


}