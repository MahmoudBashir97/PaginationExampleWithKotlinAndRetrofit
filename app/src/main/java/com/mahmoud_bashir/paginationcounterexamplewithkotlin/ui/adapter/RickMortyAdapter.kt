package com.mahmoud_bashir.paginationcounterexamplewithkotlin.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mahmoud_bashir.paginationcounterexamplewithkotlin.databinding.CharacterLayoutBinding
import com.mahmoud_bashir.paginationcounterexamplewithkotlin.models.Result

class RickMortyAdapter : PagingDataAdapter<Result, RickMortyAdapter.RickVH>(diffCallback) {


    inner class RickVH(val binding:CharacterLayoutBinding): RecyclerView.ViewHolder(binding.root)



    companion object{
        val diffCallback = object :DiffUtil.ItemCallback<Result>(){
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: RickVH, position: Int) {
        val currentItem = getItem(position)
        // this method getItem from PagingDataAdapter

        holder.binding.apply {
            tvDescription.text = "${currentItem?.name}"
            val imgUrl = currentItem?.image

            Log.d("?????","imgurl : $imgUrl")
            // this is a coroutines image loader called coil
            imageView.load(imgUrl)
            {
                crossfade(true)
                crossfade(1000)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickVH {
        return RickVH(
            CharacterLayoutBinding.inflate(
                LayoutInflater.from(parent.context)
                ,parent,false)
        )
    }

}