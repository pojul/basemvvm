package com.pojul.basemvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;
import com.pojul.basemvvm.viewmodel.BaseActVM;
import com.pojul.basemvvm.viewmodel.BaseVM;

public abstract class BaseActivity<V extends ViewDataBinding, VM extends BaseActVM> extends AppCompatActivity {

    protected V binding;
    protected VM viewModel;
    protected int layoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layoutId = initLayout();
        setContentView(layoutId);
        binding = DataBindingUtil.setContentView(this, layoutId);
        viewModel = (VM) initViewModel();
        viewModel.binding = binding;
        viewModel.activity = this;
        binding.setLifecycleOwner(this);
        initView();
        viewModel.initData();
    }

    public abstract void initView();

    protected abstract int initLayout();

    protected abstract BaseVM initViewModel();
}