/*
 * Created by Gaurav on 10/11/16 1:25 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 8/11/16 9:07 PM
 */

package gaurav.com.example.androidarchitectsample.util;

/**
 * Created by Gaurav on 07/11/16.
 */

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * This provides methods to help Activities load their UI.
 */
public class AppCompatActivityUtils extends ActivityUtils{


    public static void pushFragment(@NonNull AppCompatActivity activity,
                                    @NonNull int container,@NonNull Fragment fragment){
        checkNotNull(activity);
        checkNotNull(container);
        checkNotNull(fragment);
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.replace(container,fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.addToBackStack(fragment.getClass().getName());
        transaction.commitAllowingStateLoss();
    }

    public static void pushFragmentWithoutStack(@NonNull AppCompatActivity activity,
                                    @NonNull int container,@NonNull Fragment fragment){
        checkNotNull(activity);
        checkNotNull(container);
        checkNotNull(fragment);
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.replace(container,fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//        transaction.addToBackStack(fragment.getClass().getName());
        transaction.commitAllowingStateLoss();
    }

    public static void clearBackStack(@NonNull AppCompatActivity activity) {
        checkNotNull(activity);
        FragmentManager fm = activity.getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); i++)
            fm.popBackStack();
    }

    public static void popBackStack(@NonNull AppCompatActivity activity) {
        checkNotNull(activity);
        FragmentManager fm = activity.getSupportFragmentManager();
        fm.popBackStack();
    }

}
