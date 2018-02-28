package com.daveanthonythomas.moshipack.exampleapp.cats

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by dave on 2018-02-25.
 */
interface CatEndpoint {

    @GET("/cats")
    fun getCats(): Observable<List<Cat>>
}