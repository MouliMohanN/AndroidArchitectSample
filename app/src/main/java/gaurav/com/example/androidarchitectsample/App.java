/*
 * Created by Gaurav on 10/11/16 1:25 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 8/11/16 4:29 PM
 */

package gaurav.com.example.androidarchitectsample;

import android.app.Application;
import android.util.Log;

import gaurav.com.example.androidarchitectsample.data.Constants;
import gaurav.com.example.androidarchitectsample.data.remote.DaggerRestApiComponent;
import gaurav.com.example.androidarchitectsample.data.remote.NetModule;
import gaurav.com.example.androidarchitectsample.data.remote.RestApiComponent;

/**
 * Created by Gaurav on 07/11/16.
 */

/**
 * Even though Dagger2 allows annotating a {@link dagger.Component} as a singleton, the code itself
 * must ensure only one instance of the class is created. Therefore, we create a custom
 * {@link Application} class to store a singleton reference to the {@link
 * gaurav.com.example.androidarchitectsample.data.remote.RestApiComponent}.
 */
public class App extends Application {

    private RestApiComponent restApiComponent;
    private  AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("App : ","onCreate");
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        restApiComponent = DaggerRestApiComponent.builder()
                .appModule(appComponent.appModule())
                .netModule(new NetModule(Constants.devUrlMachineLocal,this))
                .build();

//        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//            @Override
//            public void uncaughtException(Thread thread, Throwable exception) {
//                handleUncaughtException(thread, exception);
//            }
//        });
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
    public RestApiComponent getRestApiComponent(){
        return restApiComponent;
    }

    public void handleUncaughtException (Thread thread, Throwable e)
    {
       /* Map<String, String> localImageCacheList = ((HomeActivity) getContext()).getLocalImageList();
        if(null != localImageCacheList && !localImageCacheList.isEmpty()){
            PreferenceManager.saveLocalImageCacheList(localImageCacheList);
        }*/
        Log.d("CRASHED",e.getMessage());
        System.exit(1); // kill off the crashed app
    }
}
