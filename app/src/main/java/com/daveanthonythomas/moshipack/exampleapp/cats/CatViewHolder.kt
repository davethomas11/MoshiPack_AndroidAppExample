package com.daveanthonythomas.moshipack.exampleapp.cats

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.daveanthonythomas.moshipack.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cat_card.view.*

class CatViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.cat_card, parent, false)
) {
    fun bindTo(cat: Cat?) {
        if (cat != null) {

            val picasso = Picasso.Builder(itemView.context)
                    .listener { _, _, e -> e.printStackTrace() }
                    .build()

            picasso.load(cat.image?.replace("http://", "https://"))
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(itemView.image)

            itemView.breed.text = cat.breed
        }
    }

}