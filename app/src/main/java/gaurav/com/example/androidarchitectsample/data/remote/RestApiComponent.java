/*
 * Created by Gaurav on 10/11/16 4:10 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 10/11/16 4:10 PM
 */

package gaurav.com.example.androidarchitectsample.data.remote;

import javax.inject.Singleton;

import gaurav.com.example.androidarchitectsample.AppModule;
import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Gaurav on 10/11/16.
 */

@Singleton
@Component(modules = {AppModule.class,NetModule.class})
public interface RestApiComponent {

    Retrofit retrofit();
    NetModule netModule();


}

