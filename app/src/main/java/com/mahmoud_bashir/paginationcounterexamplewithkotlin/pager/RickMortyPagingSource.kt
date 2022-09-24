package com.mahmoud_bashir.paginationcounterexamplewithkotlin.pager

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mahmoud_bashir.paginationcounterexamplewithkotlin.api.ApiService
import com.mahmoud_bashir.paginationcounterexamplewithkotlin.models.Result
import java.lang.Exception

class RickMortyPagingSource(private val api:ApiService): PagingSource<Int,Result>() {

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
       return try {
           val currentPage = params.key ?: 1
           val response = api.getAllCharacters(currentPage)
           val data = response.body()?.results?: emptyList()
           val responseData = mutableListOf<Result>()
           responseData.addAll(data)
           LoadResult.Page(
               data = responseData,
               prevKey = if (currentPage == 1)null else -1,
               nextKey = currentPage.plus(1)
           )
       }catch (e:Exception){
           LoadResult.Error(e)
       }
    }
}