/*
 * Created by Gaurav on 10/11/16 4:50 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 10/11/16 4:50 PM
 */

package gaurav.com.example.androidarchitectsample;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Gaurav on 10/11/16.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {


    Application application();
    AppModule appModule();

}
