package com.skywalker.basicsample.view

import com.skywalker.basicsample.model.Product

interface ProductClickCallback {
    fun onClick(product: Product)
}