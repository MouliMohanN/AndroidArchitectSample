/*
 * Created by Gaurav on 11/11/16 4:16 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 11/11/16 4:16 PM
 */

package gaurav.com.example.androidarchitectsample.signup.signup;

import gaurav.com.example.androidarchitectsample.data.models.BaseResponse;
import gaurav.com.example.androidarchitectsample.data.models.User;

/**
 * Created by Gaurav on 11/11/16.
 */

public class SignupResponseModel extends BaseResponse{

    String token;
    User user;

    @Override
    public String toString() {
        return "SignupResponseModel{" +
                "token='" + token + '\'' +
                ", user=" + user +
                '}';
    }
}
