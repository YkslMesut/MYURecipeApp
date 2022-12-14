package com.myu.myurecipeapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Result(
    val href : String,
    val ingredients : String,
    val thumbnail : String,
    val title : String
) : Parcelable