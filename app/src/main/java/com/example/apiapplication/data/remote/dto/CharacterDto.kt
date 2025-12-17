package com.example.apiapplication.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CharacterDto(
    val id: Int,
    val name: String,
    val images: List<String>?,
    @SerializedName("personal")
    val personal: PersonalDto?,
    val kekkeiGenkai: List<String>?,
    @SerializedName("natureType")
    val natureTypes: List<String>?

)
