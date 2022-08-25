package com.test.mvvm.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.test.mvvm.BR;

/**
 * @Description: 新闻实体类
 * @Author: ganqiubo
 * @CreateDate: 2022/8/12 16:02
 */
public class New extends BaseObservable {

    private String title;
    private String imageUrl;
    private String pageUrl;
    private String simpleDesc;
    private boolean hasThumbsUp;

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        notifyPropertyChanged(BR.imageUrl);
    }

    @Bindable
    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
        notifyPropertyChanged(BR.pageUrl);
    }

    @Bindable
    public String getSimpleDesc() {
        return simpleDesc;
    }

    public void setSimpleDesc(String simpleDesc) {
        this.simpleDesc = simpleDesc;
        notifyPropertyChanged(BR.simpleDesc);
    }

    @Bindable
    public boolean isHasThumbsUp() {
        return hasThumbsUp;
    }

    public void setHasThumbsUp(boolean hasThumbsUp) {
        this.hasThumbsUp = hasThumbsUp;
        notifyPropertyChanged(BR.hasThumbsUp);
    }
}