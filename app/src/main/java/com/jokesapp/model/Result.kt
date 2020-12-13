package com.jokesapp.model

data class Result (
    val categories : ArrayList<Category>,
    val createdAt : String,
    val updatedAt : String,

    val value : String,
    val id : String,
    val url : String,
    val icon_url : String
)