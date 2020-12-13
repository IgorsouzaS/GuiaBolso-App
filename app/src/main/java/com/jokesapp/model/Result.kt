package com.jokesapp.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Result (
    @JsonProperty("categories")
    val categories : ArrayList<Category>,

    @JsonProperty("created_at")
    val createdAt : String,

    @JsonProperty("updated_at")
    val updatedAt : String,

    @JsonProperty("value")
    val value : String,

    @JsonProperty("id")
    val id : String,

    @JsonProperty("url")
    val url : String,

    @JsonProperty("icon_url")
    val iconUrl : String
)