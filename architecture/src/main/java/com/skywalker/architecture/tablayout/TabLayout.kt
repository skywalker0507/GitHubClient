package com.skywalker.architecture.tablayout

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.DrawableRes
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.design.widget.TabLayout
import android.support.v4.util.Pools
import android.support.v7.content.res.AppCompatResources
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class TabLayout(private val mContext: Context,private val attrs:AttributeSet?,private val defStyleAttr:Int):HorizontalScrollView(mContext,attrs, defStyleAttr) {

    constructor(context: Context,attrs: AttributeSet?):this(context,attrs,0)
    constructor(context: Context):this(context,null)

    private val DEFAULT_HEIGHT_WITH_TEXT_ICON = 72 // dps
    val DEFAULT_GAP_TEXT_ICON = 8 // dps
    private val INVALID_WIDTH = -1
    private val DEFAULT_HEIGHT = 48 // dps
    private val TAB_MIN_WIDTH_MARGIN = 56 //dps
    val FIXED_WRAP_GUTTER_MIN = 16 //dps
    val MOTION_NON_ADJACENT_OFFSET = 24
    private val ANIMATION_DURATION = 300

    private val tabPool=Pools.SynchronizedPool<>(16)
    init {

    }

     class Tab{
        public val INVALID_POSITION=-1
        private lateinit var tag:Any
        private lateinit var icon:Drawable
        private lateinit var text:CharSequence
        private lateinit var contentDesc:CharSequence
        private val position=INVALID_POSITION
        private lateinit var currentView: View
    }

    internal class TabView (mContext: Context): LinearLayout(mContext){
        init {

        }
    }
}