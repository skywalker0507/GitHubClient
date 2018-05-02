package com.skywalker.basicsample.db.entity

import android.arch.persistence.room.Entity
import com.skywalker.basicsample.model.Product

@Entity(tableName = "products")
class ProductEntity(private val id:Int,private val name:String,private val description:String,private val price:Int):Product {

    constructor(product: Product):this(product.getId(),product.getName(),product.getDescription(),product.getPrice())

    override fun getId(): Int {
        return id
    }

    override fun getName(): String {
        return name
    }

    override fun getDescription(): String {
        return description
    }

    override fun getPrice(): Int {
        return price
    }
}