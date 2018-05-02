package com.skywalker.basicsample.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import com.skywalker.basicsample.BasicApplication
import com.skywalker.basicsample.db.entity.ProductEntity

class ProductListViewModel(application: Application) : AndroidViewModel(application) {
    private val observableProducts = MediatorLiveData<List<ProductEntity>>()

    init {
        observableProducts.value = null
        val products = (application as BasicApplication).getRepository().getProducts()
        observableProducts.addSource(products, {
            observableProducts.value = it
        })
    }

    fun getProducts(): LiveData<List<ProductEntity>> {
        return observableProducts
    }
}