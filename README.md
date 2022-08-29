#### A Simple Android MVVM Framework


```java
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

}
```