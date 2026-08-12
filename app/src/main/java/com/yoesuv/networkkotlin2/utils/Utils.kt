package com.yoesuv.networkkotlin2.utils

import android.view.View
import androidx.annotation.ColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding

internal fun View.insetsPadding(
    left: Boolean = false,
    top: Boolean = false,
    right: Boolean = false,
    bottom: Boolean = false,
    @ColorInt color: Int? = null,
) {
    val initialPadding =
        intArrayOf(
            paddingLeft,
            paddingTop,
            paddingRight,
            paddingBottom,
        )

    ViewCompat.setOnApplyWindowInsetsListener(this) { v, insets ->
        if (color != null) {
            v.setBackgroundColor(color)
        }
        val bars =
            insets.getInsets(
                WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout(),
            )
        v.updatePadding(
            initialPadding[0] + if (left) bars.left else 0,
            initialPadding[1] + if (top) bars.top else 0,
            initialPadding[2] + if (right) bars.right else 0,
            initialPadding[3] + if (bottom) bars.bottom else 0,
        )
        insets
    }
}
