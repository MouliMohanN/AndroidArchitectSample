/*
 * Created by Gaurav on 10/11/16 1:25 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 9/11/16 7:39 PM
 */

package gaurav.com.example.androidarchitectsample.signup.signup;

/**
 * Created by Gaurav on 09/11/16.
 */

import dagger.Module;
import dagger.Provides;

/**
 * This is a Dagger module. We use this to pass in the View dependency to the
 * {@link SignupPresenter}.
 */
@Module
public class SignupPresenterModule {

    private final SignupContract.View mView;

    public SignupPresenterModule(SignupContract.View view) {
        mView = view;
    }

    @Provides
    SignupContract.View provideSignupContractView() {
        return mView;
    }

}
