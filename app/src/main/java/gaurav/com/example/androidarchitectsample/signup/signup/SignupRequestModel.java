/*
 * Created by Gaurav on 11/11/16 4:11 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 11/11/16 4:11 PM
 */

package gaurav.com.example.androidarchitectsample.signup.signup;

import android.support.annotation.NonNull;

/**
 * Created by Gaurav on 11/11/16.
 */

public class SignupRequestModel  {

    @NonNull
    String mobile;
    @NonNull
    String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SignupRequestModel{" +
                "mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
