package com.daveanthonythomas.moshipack.exampleapp.cats

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import org.koin.android.ext.android.inject

/**
 * Created by dave on 2018-02-27.
 */
class CatsViewModel(app: Application) : AndroidViewModel(app) {
    private val catDao: CatDao by app.inject()
    val catsList: LiveData<PagedList<Cat>>

    init {
        catsList = LivePagedListBuilder(catDao.cats, 10).build()
    }
}