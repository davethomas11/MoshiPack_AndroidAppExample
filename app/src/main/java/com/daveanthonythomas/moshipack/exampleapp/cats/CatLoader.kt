package com.daveanthonythomas.moshipack.exampleapp.cats

import com.daveanthonythomas.moshipack.exampleapp.AppDatabase
import io.reactivex.schedulers.Schedulers

/**
 * Created by dave on 2018-02-25.
 */
class CatLoader(private val endpoint: CatEndpoint,
                private val appDatabase: AppDatabase) {


    fun request() {
        endpoint.getCats()
                .observeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe {
                    appDatabase.beginTransaction()
                    try {
                        it.forEach { cat -> appDatabase.getCatDao().insert(cat) }
                        appDatabase.setTransactionSuccessful()
                    } finally {
                        appDatabase.endTransaction()
                    }
                }
    }
}