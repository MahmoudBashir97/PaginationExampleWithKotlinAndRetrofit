package com.mahmoud_bashir.paginationcounterexamplewithkotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mahmoud_bashir.paginationcounterexamplewithkotlin.R
import com.mahmoud_bashir.paginationcounterexamplewithkotlin.databinding.ActivityMainBinding
import com.mahmoud_bashir.paginationcounterexamplewithkotlin.ui.adapter.RickMortyAdapter
import com.mahmoud_bashir.paginationcounterexamplewithkotlin.ui.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var mAdapter:RickMortyAdapter

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRV()
        loadingData()
    }

    private fun loadingData() {
        lifecycleScope.launch{
            viewModel.listData.collect{ pagingData ->
                mAdapter.submitData(pagingData)
            }
        }
    }

    private fun setUpRV() {
        mAdapter = RickMortyAdapter()
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
            adapter = mAdapter
        }
    }


}