package com.skywalker.github

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.content.pm.ProviderInfo
import android.database.Cursor
import android.net.Uri

class LibraryInitProvider:ContentProvider(){
    override fun insert(uri: Uri?, values: ContentValues?): Uri? {
        return null
    }

    override fun query(uri: Uri?, projection: Array<out String>?, selection: String?, selectionArgs: Array<out String>?, sortOrder: String?): Cursor? {
        return null
    }

    override fun onCreate(): Boolean {
        //init
        return true
    }

    override fun update(uri: Uri?, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?): Int {
        return 0
    }

    override fun delete(uri: Uri?, selection: String?, selectionArgs: Array<out String>?): Int {
        return 0
    }

    override fun getType(uri: Uri?): String? {
        return null
    }

    override fun attachInfo(context: Context?, info: ProviderInfo?) {
        if (info==null){
            throw NullPointerException()

        }

        if ("  ".equals(info.authority)){
            throw IllegalStateException()
        }

        super.attachInfo(context, info)
    }

}