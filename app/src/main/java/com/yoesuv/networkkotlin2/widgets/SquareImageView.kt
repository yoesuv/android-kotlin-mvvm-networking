package com.yoesuv.networkkotlin2.widgets

import android.content.Context
import androidx.appcompat.widget.AppCompatImageView
import android.util.AttributeSet

/**
 *  Created by yusuf on 1/14/18.
 */
class SquareImageView: AppCompatImageView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(measuredWidth, measuredWidth)
    }

}