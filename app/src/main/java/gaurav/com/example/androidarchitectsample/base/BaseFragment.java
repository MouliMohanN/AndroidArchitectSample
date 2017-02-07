/*
 * Created by Gaurav on 10/11/16 1:25 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 8/11/16 4:26 PM
 */

package gaurav.com.example.androidarchitectsample.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v4.app.Fragment;

import gaurav.com.example.androidarchitectsample.R;
import gaurav.com.example.androidarchitectsample.util.AndroidUtil;

/**
 * Created by Gaurav on 07/11/16.
 */

public abstract class BaseFragment extends Fragment implements BaseView{

    private ProgressDialog progressDialog;


    @Override
    public void showProgress() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage(getString(R.string.loading_msg));
            progressDialog.setIndeterminate(true);
            progressDialog.setCancelable(false);

        }
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void showError(String message) {
        AndroidUtil.showSnackBar(getView(), message);
    }


    @Override
    public Context getAppContext() {
        return getActivity().getApplicationContext();
    }
}
