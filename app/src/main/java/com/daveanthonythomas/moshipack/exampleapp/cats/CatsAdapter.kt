package com.daveanthonythomas.moshipack.exampleapp.cats

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.view.ViewGroup

/**
 * Created by dave on 2018-02-27.
 */
class CatsAdapter : PagedListAdapter<Cat, CatViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CatViewHolder(parent)

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Cat>() {
            override fun areItemsTheSame(oldItem: Cat, newItem: Cat): Boolean =
                    oldItem.breed == newItem.breed

            override fun areContentsTheSame(oldItem: Cat, newItem: Cat): Boolean =
                    oldItem == newItem
        }
    }
}