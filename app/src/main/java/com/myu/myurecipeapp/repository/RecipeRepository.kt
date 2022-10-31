package com.myu.myurecipeapp.repository

import com.myu.myurecipeapp.api.ApiService
import javax.inject.Inject

class RecipeRepository @Inject constructor(
    private val api : ApiService
) {
    suspend fun getRecipe () = api.getRecipe()
}