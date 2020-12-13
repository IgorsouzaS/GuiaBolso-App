package com.jokesapp.service

import com.jokesapp.model.Category
import com.jokesapp.model.Response
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class ChuckNorrisService {

    private val URL_BASE = "https://api.chucknorris.io"

    private val api = Retrofit.Builder().baseUrl(URL_BASE)
        .addConverterFactory(JacksonConverterFactory.create())
        .build()
        .create(ChuckNorrisInterface::class.java)

    fun getJokesList() : Call<List<Category>> = api.listJokes()

    fun getByText(text: String): Call<Response> = api.listByText(text)
}