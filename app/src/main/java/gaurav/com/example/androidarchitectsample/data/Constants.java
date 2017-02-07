/*
 * Created by Gaurav on 17/11/16 6:17 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 17/11/16 6:17 PM
 */

package gaurav.com.example.androidarchitectsample.data;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Gaurav on 17/11/16.
 */

public class Constants {
    public static final String devUrlHeroku = "https://cardstel.herokuapp.com";
    public static final String devUrlMachineLocal = "http://10.0.2.2:3005";
    public static final String devUrlNetworkLocal = "http://10.0.2.2:3005";
    // Describes when the annotation will be discarded
    @Retention(RetentionPolicy.SOURCE)
    // Enumerate valid values for this interface
    @StringDef({ devUrlHeroku, devUrlMachineLocal, devUrlNetworkLocal })
    // Create an interface for validating int types
    public @interface RemoteUrl { }
}
