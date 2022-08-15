package com.pojul.basemvvm.viewmodel;

import androidx.databinding.ViewDataBinding;

public abstract class BaseVM<T extends ViewDataBinding>{

    public T binding;
    public abstract void initData();

}
