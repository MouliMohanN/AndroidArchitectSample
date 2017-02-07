/*
 * Created by Gaurav on 10/11/16 1:25 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 9/11/16 2:20 PM
 */

package gaurav.com.example.androidarchitectsample.util;

/**
 * Created by Gaurav on 07/11/16.
 */

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * This provides methods to help Activities load their UI.
 */
public class ActivityUtils {

    /**
     * The {@code fragment} is added to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     */
    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int frameId) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }

    public static void pushFragment(@NonNull Activity activity,
                                    @NonNull int container,@NonNull Fragment fragment){
        checkNotNull(activity);
        checkNotNull(container);
        checkNotNull(fragment);
        FragmentTransaction transaction = activity.getFragmentManager().beginTransaction();
        transaction.replace(container,fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.addToBackStack(fragment.getClass().getName());
        transaction.commitAllowingStateLoss();
    }

    public static void clearBackStack(@NonNull Activity activity) {
        checkNotNull(activity);
        FragmentManager fm = activity.getFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); i++)
            fm.popBackStack();
    }
    public static void popBackStack(@NonNull Activity activity) {
        checkNotNull(activity);
        FragmentManager fm = activity.getFragmentManager();
        fm.popBackStack();
    }

    public static void startActivity(Activity context, Class<?> targetActivity, Bundle bundle){
        Intent intent = new Intent(context,targetActivity);
        if(bundle != null){
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }

    public static void startActivityForResult(Activity context, Class<?> targetActivity,int requestCode, Bundle bundle){
        Intent intent = new Intent(context,targetActivity);
        if(bundle != null){
            intent.putExtras(bundle);
        }
        context.startActivityForResult(intent,requestCode);
    }



}
