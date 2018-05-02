package com.skywalker.architecture.lifecycle

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class TestActivity1 :AppCompatActivity(){

    private lateinit var presenter:IPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter=MyPresenter()
        lifecycle.addObserver(presenter)
    }
}
