/*
 * Created by Gaurav on 10/11/16 1:25 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 8/11/16 4:26 PM
 */

package gaurav.com.example.androidarchitectsample.base;

import android.content.Context;

/**
 * Created by Gaurav on 07/11/16.
 */

public interface BaseView {

//    void setPresenter(BasePresenter presenter);
    boolean isActive();

    void showProgress();
    void hideProgress();
    void showError(String message);

    Context getAppContext();
}
