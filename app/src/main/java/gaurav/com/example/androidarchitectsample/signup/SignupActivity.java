/*
 * Created by Gaurav on 10/11/16 1:25 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 10/11/16 12:51 PM
 */

package gaurav.com.example.androidarchitectsample.signup;

import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import gaurav.com.example.androidarchitectsample.R;
import gaurav.com.example.androidarchitectsample.base.BaseActivity;
import gaurav.com.example.androidarchitectsample.signup.signup.SignupFragment;
import gaurav.com.example.androidarchitectsample.util.AppCompatActivityUtils;

/**
 * Created by Gaurav on 09/11/16.
 */

public class SignupActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fullscreen);
        Toast.makeText(this, "SignUp Activity", Toast.LENGTH_SHORT).show();
        showSignupFragment();
    }

    public void showSignupFragment() {
        SignupFragment signupFragment = SignupFragment.newInstance();
        AppCompatActivityUtils.pushFragment(this, R.id.fl_fullscreen, signupFragment);
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() == 0) {
            ActivityCompat.finishAffinity(this);
        }
    }
}
