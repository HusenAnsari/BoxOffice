package com.husenansari.boxoffice.api.call;

import android.content.Context;

import com.husenansari.boxoffice.api.ApiInterface;
import com.husenansari.boxoffice.api.model.MainResponse;
import com.husenansari.boxoffice.api.model.results;
import com.husenansari.boxoffice.helper.ApiConstants;
import com.husenansari.boxoffice.helper.AppConstant;
import com.husenansari.boxoffice.helper.MyApplication;
import com.husenansari.boxoffice.helper.ProgressBarHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gulamhusen on 05-07-2017.
 */

public class GetData {
    private OnGetData onGetData;
    private ProgressBarHelper progressBarHelper;
    private String movie_type;


    public GetData(String type,Context context, OnGetData onGetData) {
        this.movie_type = type;
        this.onGetData = onGetData;
        progressBarHelper = new ProgressBarHelper(context, false);
        call();
    }

    private void call() {
        progressBarHelper.showProgressDialog();

        ApiInterface api = MyApplication.getRetrofit().create(ApiInterface.class);
        api.getMovie(movie_type, AppConstant.KEY).enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                progressBarHelper.hideProgressDialog();
                if(response.body()!=null){
                    onGetData.onSuccess(response.body().getResults());
                }else{
                    onGetData.onFail();
                }
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                progressBarHelper.hideProgressDialog();
                onGetData.onFail();
            }
        });
    }


    public interface OnGetData {
        void onSuccess(ArrayList<results> results);
        void onFail();
    }
}
