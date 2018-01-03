package com.husenansari.boxoffice.api;

import com.husenansari.boxoffice.api.model.MainResponse;
import com.husenansari.boxoffice.helper.ApiConstants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by gulamhusen on 05-07-2017.
 */

public interface ApiInterface {

    @GET(ApiConstants.MOVIE)
    Call<MainResponse> getMovie(@Query("sort_by") String sort ,@Query("api_key") String key);

 /*   @GET(ApiConstants.TOP_RATED)
    Call<MainResponse>getToprated(@Query("api_key") String key);

    @GET(ApiConstants.POPULAR)
    Call<MainResponse>getPopular(@Query("api_key") String key);*/
}
