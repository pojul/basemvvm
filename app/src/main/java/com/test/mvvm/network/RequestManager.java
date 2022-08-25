package com.test.mvvm.network;

import com.google.gson.Gson;
import com.pojul.basemvvm.network.BaseCallback;
import com.pojul.basemvvm.network.BaseResp;
import com.test.mvvm.network.resp.GetNewsResp;
import com.test.mvvm.network.resp.GetUserResp;

import java.util.Map;

public class RequestManager {

    public static void getUser(Map<String, String> params, BaseCallback<GetUserResp> callback){
        String json = "{'code':1 ,'errMsg':'success','user':{'userName':'admin0','nickName':'jack','age':20,'sex':1,'photo':'http://img.touxiangwu.com/2020/3/FfURjq.jpg'}}";
        if(callback==null){
            return;
        }
        callback.onSuccess(new Gson().fromJson(json, callback.type));
    }


    public static void getNews(Map<String, String> params, BaseCallback<GetNewsResp> callback){
        String json = "{'code':1 ,'errMsg':'success','news':[{'title':'title--->1','imageUrl':'https://img03.sogoucdn.com/app/a/07/b4f5a091fb5c7d40d7b74893392a705b','simpleDesc':'simpleDesc--simpleDesc--simpleDesc--simpleDesc--simpleDesc--simpleDesc------->1'}, {'title':'title--->2','imageUrl':'http://img.mp.itc.cn/upload/20161028/b09e57227d984f2b8a6295f10dd4f67e_th.jpeg','simpleDesc':'simpleDesc--simpleDesc--simpleDesc--simpleDesc--simpleDesc--simpleDesc------->2'},{'title':'title--->3','imageUrl':'https://img03.sogoucdn.com/app/a/07/e58d89131f3a0882b804313208e0e983','simpleDesc':'simpleDesc--simpleDesc--simpleDesc--simpleDesc--simpleDesc--simpleDesc------->3'}]}";
        if(callback==null){
            return;
        }
        callback.onSuccess(new Gson().fromJson(json, callback.type));
    }


    public interface CallBack{
        void onsuccess(BaseResp resp);
        void onerror(String error);
    }


}
