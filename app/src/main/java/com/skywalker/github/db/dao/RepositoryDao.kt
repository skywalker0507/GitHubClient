package com.skywalker.github.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.skywalker.github.model.Repository

@Dao
abstract class RepositoryDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg :Repository)

    @Query("select * from repository")
    abstract fun load(owner:String,name:String):LiveData<Repository>
}