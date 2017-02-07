/*
 * Created by Gaurav on 10/11/16 1:26 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 10/11/16 1:26 PM
 */

package gaurav.com.example.androidarchitectsample.data.remote;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.Modifier;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import gaurav.com.example.androidarchitectsample.data.Constants;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Gaurav on 10/11/16.
 */
@Module
public class NetModule {

    String mBaseUrl;
    Context context;

    // Constructor needs one parameter to instantiate.
    public NetModule(@Constants.RemoteUrl String baseUrl,Context context) {
        this.mBaseUrl = baseUrl;
        this.context = context;
    }

    // Dagger will only look for methods annotated with @Provides
    @Provides
    @Singleton
    NetModule provideNetModuel(){
        return this;
    }

    @Provides
    @Singleton
    Cache provideOkHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC);
//        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }
    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return logging;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache,HttpLoggingInterceptor loggingInterceptor) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();
        return client;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(new ToStringConverterFactory())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    public void executeRequest(Call<?> request,Retrofit retrofit) {
        APIServiceHelper serviceHelper = new APIServiceHelper();
        if (!NetworkUtil.isNetworkAvailable(context)) {
            serviceHelper.setActionType(APIServiceHelper.ActionType.NO_INTERNET);
            EventBus.getDefault().post(serviceHelper);
            return;
        }
        serviceHelper.setActionType(APIServiceHelper.ActionType.START_REQUEST);
        EventBus.getDefault().post(serviceHelper);
        request.enqueue(new CallbackHandler(retrofit));
    }

    public void executeRequestInBackGround(Call<?> request,Retrofit retrofit) {
        if (!NetworkUtil.isNetworkAvailable(context)) {
            return;
        }
        request.enqueue(new CallbackHandler(retrofit));
    }
}
