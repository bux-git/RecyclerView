package com.dqr.www.recyclerview.api;

import com.dqr.www.recyclerview.bean.BaseBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-28 14:57
 */

public abstract class BaseCallBack <T extends BaseBean> implements Callback<T> {


    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        int code=response.raw().code();
        T t=(T)response.body();
        if(code==200){
            if(t.isError()){
                onFail(t.getMessage());

            }else{
                onSuccess(t);
            }
        }else{
            onFail(code+" 网络请求错误");

        }
        onAfter();
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onFail(t.getMessage());
    }

    protected abstract  void onSuccess(T result);

    protected abstract void onFail(String msg);

    protected  void onAfter(){
    };


}
