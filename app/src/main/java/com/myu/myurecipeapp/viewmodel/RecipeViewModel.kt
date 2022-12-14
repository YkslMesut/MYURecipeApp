package com.myu.myurecipeapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myu.myurecipeapp.models.RecipeResponse
import com.myu.myurecipeapp.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel
@Inject constructor(private  val repository : RecipeRepository) : ViewModel ()
{
    private val TAG = "RecipeViewModel"

    private val _response = MutableLiveData<RecipeResponse>()
    val recipeResponse : LiveData<RecipeResponse>
    get() = _response

    init {
        getRecipe()
    }

    private fun getRecipe() = viewModelScope.launch {
        repository.getRecipe().let { response ->
            Log.d(TAG, "getRecipe: " + response.code())
            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d(TAG, "getRecipe: " + response.code())
            }
        }
    }


}