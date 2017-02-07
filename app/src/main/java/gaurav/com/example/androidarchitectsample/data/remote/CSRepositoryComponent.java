/*
 * Created by Gaurav on 10/11/16 1:25 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 8/11/16 4:29 PM
 */

package gaurav.com.example.androidarchitectsample.data.remote;

/**
 * Created by Gaurav on 07/11/16.
 */

import javax.inject.Singleton;

import gaurav.com.example.androidarchitectsample.App;
import gaurav.com.example.androidarchitectsample.AppModule;
import dagger.Component;

/**
 * This is a Dagger component. Refer to {@link App} for the list of Dagger components
 * used in this application.
 * <P>
 * Even though Dagger allows annotating a {@link Component @Component} as a singleton, the code
 * itself must ensure only one instance of the class is created. This is done in {@link
 * App}.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface CSRepositoryComponent {

}
