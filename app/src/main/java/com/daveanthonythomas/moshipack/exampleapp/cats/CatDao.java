package com.daveanthonythomas.moshipack.exampleapp.cats;

import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

/**
 * Created by dave on 2018-02-24.
 */

@Dao
public interface CatDao {

    @Query("SELECT * FROM Cat")
    DataSource.Factory<Integer, Cat> getCats();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Cat... cats);
}
