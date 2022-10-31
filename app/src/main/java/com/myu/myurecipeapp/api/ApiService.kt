package com.myu.myurecipeapp.api

import com.myu.myurecipeapp.models.RecipeResponse
import com.myu.myurecipeapp.util.Constants.END_POINT
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(END_POINT)
    suspend fun getRecipe() : Response<RecipeResponse>
}