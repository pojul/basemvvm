package com.test.mvvm.ui;

import android.view.View;
import android.widget.Toast;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.test.mvvm.R;
import com.pojul.basemvvm.ui.BaseActivity;
import com.test.mvvm.viewmodel.MainActVM;
import com.pojul.basemvvm.viewmodel.BaseVM;
import com.test.mvvm.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainActVM> {

    @Override
    public void initView() {
        binding.setData(viewModel);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.rvNews.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected BaseVM initViewModel() {
        return new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MainActVM.class);
    }

    public void click(View view){
        switch (view.getId()){
            case R.id.bt1:
                Toast.makeText(MainActivity.this, "bt1 click: "
                        + binding.name.getText().toString(), Toast.LENGTH_LONG).show();
                viewModel.getNews();
                break;
            case R.id.bt2:
                viewModel.getUserInfo();
                break;
            case R.id.bt3:
                viewModel.user.getValue().setNickName(binding.et.getText().toString());
                viewModel.user.getValue().setPhoto("https://img.wxcha.com/m00/86/59/7c6242363084072b82b6957cacc335c7.jpg");
                break;
        }
    }
}