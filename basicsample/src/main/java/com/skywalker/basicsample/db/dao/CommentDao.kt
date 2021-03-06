package com.skywalker.basicsample.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.skywalker.basicsample.db.entity.CommentEntity

@Dao
interface CommentDao {

    @Query("select * from comments where productId = :productId")
    fun loadComments(productId:Int):LiveData<List<CommentEntity>>

    @Query("select * from comments where productId = :productId")
    fun loadCommentsSync(productId: Int):List<CommentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(comments:List<CommentEntity>)
}