/*
 * Created by Gaurav on 10/11/16 1:25 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 10/11/16 1:23 PM
 */

package gaurav.com.example.androidarchitectsample.data.remote;

import android.content.Context;

import com.google.gson.GsonBuilder;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.Modifier;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static dagger.internal.Preconditions.checkNotNull;

public class RestClient {
    private Retrofit retrofit;
    private final static String HOST_URL = "http://192.168.0.108:8080/";
//    auth/signup

    private Context context;
    private String baseUrl = "";

    private RestClient(Context context, String hostUrl) {
        this.context = context;
        this.baseUrl = hostUrl;
    }


//    public void setAuthToken(final String token) {
//        OkHttpClient client = ;
//        client.interceptors().add(new Interceptor() {
//            @Override
//            public Response intercept(Interceptor.Chain chain) throws IOException {
//                Response response = chain.proceed(chain.request());
//                if (token != null && !token.isEmpty()) {
//                    response.header("Authorization", "JWT " + token);
//                }
//                // Do anything with response here
//
//                return response;
//            }
//        });
//    }
    public Retrofit build() {
        checkNotNull(HOST_URL, "baseURL should not be null.. check in string.xml");
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                                      .connectTimeout(10, TimeUnit.SECONDS)
                                      .writeTimeout(10, TimeUnit.SECONDS)
                                      .readTimeout(30, TimeUnit.SECONDS)
                                      .addInterceptor(logging)
                                      .build();
        retrofit = new Retrofit.Builder()
                           .baseUrl(HOST_URL)
                           .addConverterFactory(new ToStringConverterFactory())
                           .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                           .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC).create()))
                           .client(client)
                           .build();

        return retrofit;

    }


    public void executeRequest(Call<?> request) {
        APIServiceHelper serviceHelper = new APIServiceHelper();
        if (!NetworkUtil.isNetworkAvailable(context)) {
            serviceHelper.setActionType(APIServiceHelper.ActionType.NO_INTERNET);
            EventBus.getDefault().post(serviceHelper);
        }
        serviceHelper.setActionType(APIServiceHelper.ActionType.START_REQUEST);
        EventBus.getDefault().post(serviceHelper);
        request.enqueue(new CallbackHandler(retrofit));
    }

    public void executeRequestInBackGround(Call<?> request) {
        request.enqueue(new CallbackHandler(retrofit));
    }

}
