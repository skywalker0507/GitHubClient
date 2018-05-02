package com.skywalker.basicsample

import android.app.Application
import com.skywalker.basicsample.db.AppDatabase

class BasicApplication:Application() {

    private lateinit var executors: AppExecutors
    override fun onCreate() {
        super.onCreate()
        executors= AppExecutors()
    }

    fun getDatabase():AppDatabase{
        return AppDatabase.getInstance(this,executors)
    }

    fun getRepository():DataRepository{
        return DataRepository.getInstance(getDatabase())
    }
}