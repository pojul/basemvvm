package com.pojul.basemvvm.viewmodel;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;

public abstract class BaseVM<T extends ViewDataBinding> extends ViewModel {

    public T binding;
    public abstract void initData();

}
