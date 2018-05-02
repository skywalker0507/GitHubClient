package com.skywalker.basicsample.db

import com.skywalker.basicsample.db.entity.ProductEntity
import java.util.*
import kotlin.collections.ArrayList
import com.skywalker.basicsample.db.entity.CommentEntity

import java.util.concurrent.TimeUnit


class DataGenerator {
    companion object {
        private val FIRST= arrayOf("Special edition", "New", "Cheap", "Quality", "Used")
        private val SECOND= arrayOf("Three-headed Monkey", "Rubber Chicken", "Pint of Grog", "Monocle")
        private val DESCRIPTION= arrayOf("is finally here", "is recommended by Stan S. Stanman",
                "is the best sold product on Mêlée Island", "is \uD83D\uDCAF", "is ❤️", "is fine")
        private val COMMENTS= arrayOf("Comment 1", "Comment 2", "Comment 3", "Comment 4", "Comment 5", "Comment 6")

        fun generateProducts():List<ProductEntity>{
            val random=Random()
            val products=ArrayList<ProductEntity>(FIRST.size * SECOND.size)
            for (i in 0..FIRST.size){
                for (j in 0..SECOND.size){
                    val product=ProductEntity(
                            name = "$FIRST[i] $SECOND[i]",
                            description = DESCRIPTION[i],
                            price = random.nextInt(240),
                            id = FIRST.size*i +j+1
                    )
                    products.add(product)
                }

            }

            return products
        }

        fun generateCommentsForProducts(products: List<ProductEntity>) :List<CommentEntity>{
            val comments = ArrayList<CommentEntity>()
            val random = Random()

            for (product in products){
                val number=random.nextInt(5)+1
                for (i in 0..number){
                    val comment=CommentEntity()
                    comment.apply {
                        setId(product.getId())
                        setText("${COMMENTS[i]} for ${product.getName()}")
                        setPostedAt(Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(number-i.toLong())+TimeUnit.HOURS.toMillis(i.toLong())))
                    }

                    comments.add(comment)
                }
            }
            return comments
        }
    }
}