package com.yoesuv.networkkotlin2.utils;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public final class DataBindingAdapters {
    private DataBindingAdapters() {
    }

    @BindingAdapter("loadImage")
    public static void loadImage(
            AppCompatImageView view,
            ObservableField<String> imageUrl
    ) {
        BindingExtensionKt.loadImage(view, imageUrl);
    }

    @BindingAdapter("setIsRefreshing")
    public static void setIsRefreshing(
            SwipeRefreshLayout view,
            MutableLiveData<Boolean> value
    ) {
        BindingExtensionKt.setIsRefreshing(view, value);
    }
}
