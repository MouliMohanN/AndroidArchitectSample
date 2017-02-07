/*
 * Created by Gaurav on 10/11/16 1:25 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 9/11/16 3:37 PM
 */

package gaurav.com.example.androidarchitectsample.data.remote;

import gaurav.com.example.androidarchitectsample.signup.signup.SignupRequestModel;
import gaurav.com.example.androidarchitectsample.signup.signup.SignupResponseModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * Created by Gaurav on 9/28/16.
 */

public interface APIService {

    @POST("/user/signup")
    Call<SignupResponseModel> emailSignUp(@Body SignupRequestModel signupRequestModel);

    @POST("/user/login")
    Call<SignupResponseModel> emailSignIn(@Body SignupRequestModel signupRequestModel);



}
