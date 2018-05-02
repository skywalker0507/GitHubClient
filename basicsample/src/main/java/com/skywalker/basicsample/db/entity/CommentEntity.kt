package com.skywalker.basicsample.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import com.skywalker.basicsample.model.Comment
import java.util.*

@Entity(
        tableName = "comments",
        foreignKeys = [(ForeignKey(entity = ProductEntity::class, parentColumns = ["id"], childColumns = ["productId"], onDelete = ForeignKey.CASCADE))],
        indices = [(Index(value = ["productId"]))])


class CommentEntity : Comment {
    @PrimaryKey(autoGenerate = true)
    private var id: Int = 0
    private var productId: Int = 0
    private lateinit var text: String
    private lateinit var postedAt: Date


    constructor(id: Int, productId: Int, text: String, postedAt: Date) {
        this.id = id
        this.productId = productId
        this.text = text
        this.postedAt = postedAt
    }

    constructor()

    fun setId(id: Int) {
        this.id = id
    }

    override fun getId(): Int {
        return id
    }

    fun setProductId(productId: Int) {
        this.productId = productId

    }

    override fun getProductId(): Int {
        return productId
    }

    fun setText(text: String) {
        this.text = text
    }

    override fun getText(): String {
        return text
    }

    fun setPostedAt(postedAt: Date) {
        this.postedAt = postedAt
    }

    override fun getPostedAt(): Date {

        return postedAt
    }


}