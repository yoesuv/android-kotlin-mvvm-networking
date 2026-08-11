package com.yoesuv.networkkotlin2.utils

import android.os.Build
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
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
        ViewCompat.setOnApplyWindowInsetsListener(this) { v, insets ->
            if (color != null) {
                v.setBackgroundColor(color)
            }
            val bars =
                insets.getInsets(
                    WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout(),
                )
            v.updatePadding(
                if (left) bars.left else v.paddingLeft,
                if (top) bars.top else v.paddingTop,
                if (right) bars.right else v.paddingRight,
                if (bottom) bars.bottom + 32 else v.paddingBottom,
            )
            insets
        }
    }
}
