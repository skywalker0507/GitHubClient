package com.skywalker.basicsample.db

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import android.support.annotation.VisibleForTesting
import com.skywalker.basicsample.AppExecutors
import com.skywalker.basicsample.db.dao.CommentDao
import com.skywalker.basicsample.db.dao.ProductDao
import com.skywalker.basicsample.db.entity.CommentEntity
import com.skywalker.basicsample.db.entity.ProductEntity


@Database(entities = [ProductEntity::class,CommentEntity::class],version = 1)
@TypeConverters(DateConverter::class)
abstract class AppDatabase:RoomDatabase() {

    abstract fun productDao(): ProductDao
    abstract fun commentDao():CommentDao

    private val isDatabaseCreated=MutableLiveData<Boolean>()

    companion object {

        private lateinit var instance:AppDatabase

        @VisibleForTesting
        val DATABASE_NAME = "basic-sample-db"

        fun getInstance(context: Context,executors: AppExecutors):AppDatabase{
            if (instance==null){
                synchronized(AppDatabase::class){
                    if (instance==null){
                        instance= buildDatabase(context.applicationContext,executors);
                        instance.updateDatabaseCreated(context.applicationContext)
                    }
                }
            }

            return instance
        }

        private fun buildDatabase(context: Context,executors: AppExecutors):AppDatabase{
            return Room.databaseBuilder(context,AppDatabase::class.java, DATABASE_NAME)
                    .addCallback(object :Callback(){
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            executors.diskIO.execute {
                                addDelay()

                                val database=AppDatabase.getInstance(context, executors)
                                val products=DataGenerator.generateProducts()
                                val comments=DataGenerator.generateCommentsForProducts(products)
                                insertData(database,products,comments)
                                database.setDatabaseCreated()
                            }
                        }
                    }).build()
        }

        private fun addDelay(){
            Thread.sleep(4000)
        }

        private fun insertData(database: AppDatabase,products:List<ProductEntity>,comments:List<CommentEntity>){
            database.runInTransaction {
                database.productDao().insertAll(products)
                database.commentDao().insertAll(comments)
            }
        }
    }

    private fun updateDatabaseCreated(context: Context){
        if (context.getDatabasePath(DATABASE_NAME).exists()){
            setDatabaseCreated()
        }
    }

    private fun setDatabaseCreated(){
        isDatabaseCreated.postValue(true)
    }

    public fun getDatabaseCreated():LiveData<Boolean>{
        return isDatabaseCreated
    }


}