/*
 * Created by Gaurav on 10/11/16 1:25 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 9/11/16 7:28 PM
 */

package gaurav.com.example.androidarchitectsample.signup.signup;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import gaurav.com.example.androidarchitectsample.App;
import gaurav.com.example.androidarchitectsample.R;
import gaurav.com.example.androidarchitectsample.base.BaseFragment;
import gaurav.com.example.androidarchitectsample.signup.SignupActivity;
import gaurav.com.example.androidarchitectsample.util.AndroidUtil;
import gaurav.com.example.androidarchitectsample.util.TextWatcherUtil;

/**
 * Created by Gaurav on 09/11/16.
 */
@EFragment(R.layout.fragment_signup)
public class SignupFragment extends BaseFragment implements SignupContract.View {

    @Inject
    SignupPresenter mPresenter;

    @ViewById
    TextInputLayout til_signup_mobile;

    @ViewById
    TextInputLayout til_signup_pwd;

    @ViewById
    TextInputEditText et_signup_mobile;

    @ViewById
    TextInputEditText et_signup_password;

    @Click
    void tv_signUp() {
        if (mPresenter != null) {
            AndroidUtil.hideKeyBoard(getActivity(), et_signup_mobile);
            mPresenter.signUp(getMobileNo(), getPassword());
        } else
            Toast.makeText(getActivity(), "presenter is null", Toast.LENGTH_SHORT).show();
    }

    @Click
    void tv_login() {
        if (mPresenter != null) {
            AndroidUtil.hideKeyBoard(getActivity(), et_signup_mobile);
        } else
            Toast.makeText(getActivity(), "presenter is null", Toast.LENGTH_SHORT).show();
    }

    @AfterViews
    public void init() {
        et_signup_mobile.setText("7799112036");
        // Create the presenter
        DaggerSignupComponent.builder()
                .restApiComponent(((App) getActivity().getApplication()).getRestApiComponent())
                .signupPresenterModule(new SignupPresenterModule(this))
                .build().inject(this);
    }

    @Override
    public String getMobileNo() {
        return et_signup_mobile.getText().toString();
    }

    @Override
    public String getPassword() {
        return et_signup_password.getText().toString();
    }

    public static SignupFragment newInstance() {
        return new SignupFragment_();
    }

    @Override
    public void showEmptyMobileError() {
        String erroMessage = getString(R.string.error_field_required, getString(R.string.all_mobileNo));
        til_signup_mobile.setError(erroMessage);
        et_signup_mobile.addTextChangedListener(new TextWatcherUtil(til_signup_mobile, et_signup_mobile, erroMessage));
    }

    @Override
    public void showEmptyPasswordError() {
        String erroMessage = getString(R.string.error_field_required, getString(R.string.all_password));
        til_signup_pwd.setError(erroMessage);
        et_signup_password.addTextChangedListener(new TextWatcherUtil(til_signup_pwd, et_signup_password, erroMessage));

    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.pause();
    }
}
