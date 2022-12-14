package com.test.mvvm.viewmodel;

import android.util.Log;
import android.widget.Toast;

import androidx.databinding.ObservableField;

import com.test.mvvm.databinding.ActivityMainBinding;
import com.pojul.basemvvm.network.BaseCallback;
import com.test.mvvm.network.resp.GetNewsResp;
import com.test.mvvm.network.resp.GetUserResp;
import com.test.mvvm.ui.adapter.NewsAdapter;
import com.pojul.basemvvm.viewmodel.BaseActVM;
import com.test.mvvm.network.RequestManager;
import com.test.mvvm.model.User;

import java.util.HashMap;

public class MainActVM extends BaseActVM<ActivityMainBinding>{

    public ObservableField<User> user = new ObservableField<>();
    private NewsAdapter newsAdapter;

    @Override
    public void initData() {
        newsAdapter = new NewsAdapter();
        binding.rvNews.setAdapter(newsAdapter);
        newsAdapter.setItemClickListener(item -> {
            item.setHasThumbsUp(!item.isHasThumbsUp());
            Toast.makeText(activity, "ItemClick: " + item.getTitle(), Toast.LENGTH_LONG).show();
        });
        getUserInfo();
        getNews();
    }

    public void getUserInfo() {
        RequestManager.getUser(new HashMap<>(), new BaseCallback<GetUserResp>() {
            @Override
            public void onSuccess(GetUserResp resp) {
                Log.e("getUserInfo", "onSuccess");
                user.set(resp.user);
            }

            @Override
            public void onerror(String error) {
            }
        });
    }

    public void getNews() {
        RequestManager.getNews(new HashMap<>(), new BaseCallback<GetNewsResp>() {
            @Override
            public void onSuccess(GetNewsResp resp) {
                Log.e("getNews", "onSuccess");
                newsAdapter.addData(resp.news);
            }

            @Override
            public void onerror(String error) {

            }
        });
    }
}
