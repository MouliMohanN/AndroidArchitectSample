/*
 * Created by Gaurav on 10/11/16 1:25 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 9/11/16 2:56 PM
 */

package gaurav.com.example.androidarchitectsample.signup.signup;

import gaurav.com.example.androidarchitectsample.base.BasePresenter;
import gaurav.com.example.androidarchitectsample.base.BaseView;

/**
 * Created by Gaurav on 09/11/16.
 */

public interface SignupContract {

    interface View extends BaseView {

        String getMobileNo();
        String getPassword();
        void showEmptyMobileError();
        void showEmptyPasswordError();

    }

    interface Presenter extends BasePresenter {

        void signUp(String mobileNo, String password);
        void emailSignIn(String mobileNo, String password);
    }
}
