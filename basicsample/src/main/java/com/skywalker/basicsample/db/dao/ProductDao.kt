package com.skywalker.basicsample.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.skywalker.basicsample.db.entity.ProductEntity
import com.skywalker.basicsample.model.Product

interface ProductDao {

    @Query("select * from products")
    fun loadAllProducts():LiveData<List<ProductEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(products: List<Product>)

    @Query("select * from products where id = :productId")
    fun loadProduct(productId:Int):LiveData<ProductEntity>

    @Query("select * from products where id = :productId")
    fun loadProductSync(productId: Int):ProductEntity
}