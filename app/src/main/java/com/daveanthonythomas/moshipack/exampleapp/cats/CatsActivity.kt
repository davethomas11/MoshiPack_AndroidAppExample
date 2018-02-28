package com.daveanthonythomas.moshipack.exampleapp.cats

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.daveanthonythomas.moshipack.R
import kotlinx.android.synthetic.main.activity_cats.*
import org.koin.android.ext.android.inject

class CatsActivity : AppCompatActivity() {

    val catLoader: CatLoader by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cats)

        catLoader.request()

        val viewModel = ViewModelProviders.of(this).get(CatsViewModel::class.java)
        val adapter = CatsAdapter()
        viewModel.catsList.observe(this,
                Observer<PagedList<Cat>> { list -> adapter.submitList(list) })
        cats.adapter = adapter
        cats.layoutManager = LinearLayoutManager(this)
    }
}
