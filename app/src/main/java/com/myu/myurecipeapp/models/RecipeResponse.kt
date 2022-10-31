package com.myu.myurecipeapp.models

data class RecipeResponse(
    val href: String,
    val results : List<Result>,
    val title : String,
    val version : Double
)