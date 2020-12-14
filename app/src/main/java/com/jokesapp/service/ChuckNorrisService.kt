package com.jokesapp.service

import com.jokesapp.model.Category
import com.jokesapp.model.Response
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory

class ChuckNorrisService {

    private val URL_BASE = "https://api.chucknorris.io"

    private val api = Retrofit.Builder().baseUrl(URL_BASE)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(JacksonConverterFactory.create())
        .build()
        .create(ChuckNorrisInterface::class.java)

    fun getJokesList() : Observable<List<Category>> = api.listJokes()

    fun getByText(text: String): Observable<Response> = api.listByText(text)
}