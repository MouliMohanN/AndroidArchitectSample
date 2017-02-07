/*
 * Created by Gaurav on 10/11/16 1:25 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 10/11/16 1:12 PM
 */

package gaurav.com.example.androidarchitectsample.data.local;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Gaurav on 10/11/16.
 */

@Module
public class DBModule {

    // Dagger will only look for methods annotated with @Provides
    @Provides
    @Singleton
    // Application reference must come from AppModule.class
    PreferenceManager providesSharedPreferences(Application application) {
        return new PreferenceManager(application);
    }

    @Provides
    @Singleton
        // Application reference must come from AppModule.class
    IDBOperations provideLocalDb() {
        return new DatabaseManager();
    }
}
