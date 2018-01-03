package com.husenansari.boxoffice.helper;

import android.app.Application;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gulamhusen on 05-07-2017.
 */

public class MyApplication extends Application{

    private static Gson gson;
    private static Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        initRetrofit();
        initGson();
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }

    public static Gson getGson() {
        return gson;
    }

    private void initRetrofit() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private void initGson(){
        gson = new GsonBuilder()
                .setLenient()
                .create();
    }
}
