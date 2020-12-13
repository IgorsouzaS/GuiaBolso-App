package com.jokesapp.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Response (
    @JsonProperty("total")
    val total: Int,

    @JsonProperty("result")
    val result : ArrayList<Result>
)