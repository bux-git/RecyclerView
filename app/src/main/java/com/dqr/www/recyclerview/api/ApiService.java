package com.dqr.www.recyclerview.api;

import com.dqr.www.recyclerview.bean.BaseBean;
import com.dqr.www.recyclerview.bean.WelfareBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-28 14:15
 */

public interface ApiService {
    @GET("data/{type}/{count}/{pageNo}")
    Call<BaseBean<List<WelfareBean>>> getSubData(@Path("type") String type, @Path("count") int count, @Path("pageNo") int pageNo);
}
