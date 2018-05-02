package com.skywalker.basicsample

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import com.skywalker.basicsample.db.AppDatabase
import com.skywalker.basicsample.db.entity.CommentEntity
import com.skywalker.basicsample.db.entity.ProductEntity

class DataRepository private constructor(private val database: AppDatabase) {
    companion object {
        private lateinit var instance: DataRepository

        fun getInstance(database: AppDatabase):DataRepository {
            if (instance == null) {
                synchronized(DataRepository::class) {
                    if (instance == null) {
                        instance = DataRepository(database)
                    }
                }
            }

            return instance
        }
    }

    private val observableProducts = MediatorLiveData<List<ProductEntity>>()

    init {
        observableProducts.addSource(database.productDao().loadAllProducts(), {
            if (database.getDatabaseCreated().value != null) {
                observableProducts.postValue(it)
            }
        })
    }

    fun getProducts(): LiveData<List<ProductEntity>> {
        return observableProducts
    }

    fun loadProduct(productId: Int): LiveData<ProductEntity> {
        return database.productDao().loadProduct(productId)
    }

    fun loadComments(productId: Int): LiveData<List<CommentEntity>> {
        return database.commentDao().loadComments(productId)
    }
}