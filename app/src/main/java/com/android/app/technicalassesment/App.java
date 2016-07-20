package com.android.app.technicalassesment;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.android.app.technicalassesment.model.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class App extends Application {

   private static Retrofit retrofitInstance;
    private static Context applicationInstance;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationInstance=getApplicationContext();
    }
    public static Context getApplicationInstance() {
        return applicationInstance;
    }

    public static Retrofit getRetrofitInstance(){

        /**
         * Creating Retrofit object and retuning for caller
         * It take BASE_URL
         * GsonConverterFactory.create() to enable GSON convertor
         */
        retrofitInstance=new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return  retrofitInstance;
    }


}
