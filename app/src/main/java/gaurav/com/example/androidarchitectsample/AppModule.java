/*
 * Created by Gaurav on 10/11/16 1:25 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 7/11/16 12:53 PM
 */

package gaurav.com.example.androidarchitectsample;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * This is a Dagger module. We use this to pass in the Context dependency to the
 * {@link gaurav.com.example.androidarchitectsample.AppComponent}.
 */

/**
 * Created by Gaurav on 07/11/16.
 */
@Module
public class AppModule {

    private final App mApp;

    AppModule(App context) {
        mApp = context;
    }

    @Provides
    Application provideContext() {
        return mApp;
    }

    @Provides
    AppModule provideAppmodule(){ return this;}
}
