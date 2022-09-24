package com.mahmoud_bashir.paginationcounterexamplewithkotlin.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.mahmoud_bashir.paginationcounterexamplewithkotlin.api.ApiService
import com.mahmoud_bashir.paginationcounterexamplewithkotlin.pager.RickMortyPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(api:ApiService):ViewModel() {

    val listData= Pager(PagingConfig(pageSize = 1)){
        RickMortyPagingSource(api)
    }.flow.cachedIn(viewModelScope)
}