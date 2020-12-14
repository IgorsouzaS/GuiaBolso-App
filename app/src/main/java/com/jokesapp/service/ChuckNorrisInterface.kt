package com.jokesapp.service

import com.jokesapp.model.Category
import com.jokesapp.model.Response
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisInterface {

    @GET("/jokes/categories")
    fun listJokes(): Observable<List<Category>>

    @GET("/jokes/search")
    fun listByText(@Query("query") query : String): Observable<Response>


}