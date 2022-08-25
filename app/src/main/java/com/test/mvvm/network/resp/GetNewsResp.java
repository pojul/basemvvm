package com.test.mvvm.network.resp;

import com.pojul.basemvvm.network.BaseResp;
import com.test.mvvm.model.New;

import java.util.List;

/**
 * @Description: 类描述
 * @Author: ganqiubo
 * @CreateDate: 2022/8/15 10:19
 */
public class GetNewsResp extends BaseResp {
    public List<New> news;
}
