package com.skywalker.architecture.lifecycle

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import com.skywalker.architecture.logE

class MyPresenter : IPresenter {
    override fun onCreate(lifecycleOwner: LifecycleOwner) {
        logE(lifecycleOwner.lifecycle.currentState.name)
        logE("onCreate")
    }

    override fun onStart(lifecycleOwner: LifecycleOwner) {
        logE("onStart")
    }

    override fun onStop(lifecycleOwner: LifecycleOwner) {
        logE("onStop")
    }

    override fun onDestroy(lifecycleOwner: LifecycleOwner) {
        logE("onDestroy")
    }

    override fun onChanged(lifecycleOwner: LifecycleOwner, event: Lifecycle.Event) {
        logE("onChanged")
    }
}