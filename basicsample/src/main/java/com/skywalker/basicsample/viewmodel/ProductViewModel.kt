package com.skywalker.basicsample.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.databinding.ObservableField
import com.skywalker.basicsample.BasicApplication
import com.skywalker.basicsample.DataRepository
import com.skywalker.basicsample.db.entity.CommentEntity
import com.skywalker.basicsample.db.entity.ProductEntity
import com.skywalker.basicsample.model.Product


class ProductViewModel(application: Application, private  val repository: DataRepository, private val productId:Int):AndroidViewModel(application) {

    val product= ObservableField<ProductEntity>()
    private val observableProduct=repository.loadProduct(productId)
    private val observableComments=repository.loadComments(productId)

    fun getComments():LiveData<List<CommentEntity>>{
        return observableComments
    }

    fun  getObservableProduct():LiveData<ProductEntity>{
        return observableProduct
    }

    fun setProduct(product: ProductEntity){
        this.product.set(product)
    }

    internal class Factory(private val application: Application,private val productId:Int ) :ViewModelProvider.NewInstanceFactory(){
        private val repository:DataRepository = (application as BasicApplication).getRepository()

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ProductViewModel(application,repository,productId) as T
        }
    }
}