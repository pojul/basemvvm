package com.pojul.basemvvm.viewmodel;

import android.app.Activity;

import androidx.databinding.ViewDataBinding;

public abstract class BaseActVM<T extends ViewDataBinding> extends BaseVM<T> {
    public Activity activity;
}
