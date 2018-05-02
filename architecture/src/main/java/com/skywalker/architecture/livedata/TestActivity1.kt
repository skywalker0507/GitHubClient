package com.skywalker.architecture.livedata

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import com.skywalker.architecture.R
import kotlinx.android.synthetic.main.activity_livedata1.*

class TestActivity1 : AppCompatActivity(){

    private lateinit var viewModel: NameViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livedata1)

        val clazz= Log::class.java
        //val t=clazz.methods
        //println(t)
        val method=clazz.getMethod("println",Int::class.java, String::class.java, String::class.java)
        method.invoke(null, 6,"123","abc")

        viewModel=ViewModelProviders.of(this).get(NameViewModel::class.java)

        val nameObserver=Observer<String>{
            tv_show.text=it

        }

        viewModel.currentName.value.observe(this,nameObserver)

        et_input.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                viewModel.currentName.value.value=s?.toString()
            }
        })
        bt_update.setOnClickListener({
            viewModel.currentName.value.value=et_input.text.toString()
        })
    }

}