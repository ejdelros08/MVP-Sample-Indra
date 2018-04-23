package com.ejdelros08.mvptest.util;


import com.ejdelros08.mvptest.AppConstants;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by LFT-PC-010 on 4/27/2017.
 */

public class RetrofitUtil {

    public static Retrofit getGSONRetrofit(){
        return baseRetrofitBuilder()
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit getGSONRetrofit(Gson gson){
        return baseRetrofitBuilder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static Retrofit getScalarsRetrofit(){
        return baseRetrofitBuilder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    public static Retrofit getScalarsGSONRetrofit(){
        return baseRetrofitBuilder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit getBasicRetrofit(){
        return baseRetrofitBuilder().build();
    }

    private static Retrofit.Builder baseRetrofitBuilder(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(interceptor).build();

        return new Retrofit.Builder()
                .client(client)
                .baseUrl(AppConstants.URL_BASE);
    }
}
