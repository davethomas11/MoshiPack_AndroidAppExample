package com.daveanthonythomas.moshipack.exampleapp.cats

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by dave on 2018-02-24.
 */

@Entity
data class Cat(
        @PrimaryKey
        var breed: String = "",
        @ColumnInfo
        var country: String? = null,
        @ColumnInfo
        var origin: String? = null,
        @ColumnInfo
        var bodytype: String? = null,
        @ColumnInfo
        var coat: String? = null,
        @ColumnInfo
        var pattern: String? = null,
        @ColumnInfo
        var image: String? = null
)
