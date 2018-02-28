package com.daveanthonythomas.moshipack.exampleapp

import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Database
import com.daveanthonythomas.moshipack.exampleapp.cats.Cat
import com.daveanthonythomas.moshipack.exampleapp.cats.CatDao


/**
 * Created by dave on 2018-02-25.
 */
@Database(entities = [(Cat::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getCatDao(): CatDao
}