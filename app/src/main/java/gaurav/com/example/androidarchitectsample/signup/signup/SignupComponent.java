/*
 * Created by Gaurav on 10/11/16 1:25 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 9/11/16 2:50 PM
 */

package gaurav.com.example.androidarchitectsample.signup.signup;

import gaurav.com.example.androidarchitectsample.data.remote.RestApiComponent;
import gaurav.com.example.androidarchitectsample.util.FragmentScoped;
import dagger.Component;

/**
 * Created by Gaurav on 09/11/16.
 */
@FragmentScoped
@Component(dependencies = {RestApiComponent.class},modules = {SignupPresenterModule.class})
public interface SignupComponent {

    void inject(SignupFragment signupFragment);
}
