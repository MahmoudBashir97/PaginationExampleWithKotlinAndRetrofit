package com.mahmoud_bashir.paginationcounterexamplewithkotlin.api

import com.mahmoud_bashir.paginationcounterexamplewithkotlin.models.GetCharacterResponse
import com.mahmoud_bashir.paginationcounterexamplewithkotlin.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getAllCharacters(
        @Query("page") page:Int
    ):Response<GetCharacterResponse>

}