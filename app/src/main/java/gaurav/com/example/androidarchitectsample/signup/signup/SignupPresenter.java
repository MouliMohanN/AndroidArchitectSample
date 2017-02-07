/*
 * Created by Gaurav on 10/11/16 1:25 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 9/11/16 2:59 PM
 */

package gaurav.com.example.androidarchitectsample.signup.signup;

import android.support.annotation.NonNull;

import com.google.common.base.Strings;

import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

import gaurav.com.example.androidarchitectsample.base.BasePresenterImpl;
import gaurav.com.example.androidarchitectsample.data.remote.APIService;
import gaurav.com.example.androidarchitectsample.data.remote.NetModule;
import gaurav.com.example.androidarchitectsample.data.remote.RestApiComponent;
import gaurav.com.example.androidarchitectsample.util.CL;
import retrofit2.Retrofit;

/**
 * Created by Gaurav on 09/11/16.
 */

public class SignupPresenter extends BasePresenterImpl implements SignupContract.Presenter {

    RestApiComponent mRestApiComponent;
    SignupContract.View mView;
    NetModule netModule;
    Retrofit retrofit;

    @Override
    public void signUp(@NonNull String mobileNo, @NonNull String password) {
        if (Strings.isNullOrEmpty(mobileNo)) {
            mView.showEmptyMobileError();
            return;
        }
        if (Strings.isNullOrEmpty(password)) {
            mView.showEmptyPasswordError();
            return;
        }
        SignupRequestModel request = new SignupRequestModel();
        request.setMobile(mobileNo);
        request.setPassword(password);
        netModule.executeRequest(retrofit.create(APIService.class).emailSignUp(request), retrofit);

    }

    @Inject
    public SignupPresenter(RestApiComponent restApiComponent, SignupContract.View view) {
        super(view);
        mRestApiComponent = restApiComponent;
        mView = view;
        netModule = mRestApiComponent.netModule();
        retrofit = mRestApiComponent.retrofit();
    }

    @Override
    public void emailSignIn(String mobileNo, String password) {
        SignupRequestModel request = new SignupRequestModel();
        request.setMobile(mobileNo);
        request.setPassword(password);
        netModule.executeRequest(retrofit.create(APIService.class).emailSignIn(request), retrofit);
    }

    @Subscribe
    public void onEvent(SignupResponseModel signupResponseModel) {

        if (signupResponseModel.isSuccess()) {
            CL.debug("USER", signupResponseModel.user.toString(), false);
            CL.debug("TOKEN", signupResponseModel.token, false);
        } else {
            CL.debug("ERROR", signupResponseModel.getError().toString(), false);
        }
    }

    void test() {

//        netModule.executeRequest();
    }
}
