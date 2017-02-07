/*
 * Created by Gaurav on 10/11/16 1:25 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 9/11/16 2:51 PM
 */

package gaurav.com.example.androidarchitectsample.util;

import android.util.Log;

/**
 * Created by Gaurav on 09/11/16.
 */

public class CL {

    private final static String TAG = "CARDSTEL";
    private final static boolean logStatus = true;

    private CL() {
    }

    public static void info(String msg) {
        info(msg,false);
    }

    public static void info(String msg,boolean writeToFirebase) {
        if(logStatus){
            Log.i(TAG, msg);
        }
        if(writeToFirebase)
            writeLogsToFireBase(TAG,msg);
    }

    public static void info(String tag,String msg,boolean writeToFirebase) {
        if(logStatus){
        Log.i(tag, msg);
        }
        if(writeToFirebase)
            writeLogsToFireBase(tag,msg);
    }

    public static void error(String msg,boolean writeToFirebase) {
        if(logStatus){
            Log.e(TAG, msg);
        }
        if(writeToFirebase)
            writeLogsToFireBase(TAG,msg);
    }

    public static void error(String tag ,String msg,boolean writeToFirebase) {
        if(logStatus){
            Log.e(tag, msg);
        }
        if(writeToFirebase)
            writeLogsToFireBase(tag,msg);
    }

    public static void debug(String msg,boolean writeToFirebase) {
        if(logStatus){
            Log.d(TAG, msg);
        }
        if(writeToFirebase)
            writeLogsToFireBase(TAG,msg);
    }

    public static void debug(String tag ,String msg,boolean writeToFirebase) {
        if(logStatus){
            Log.d(tag, msg);
        }
        if(writeToFirebase)
            writeLogsToFireBase(TAG,msg);
    }
    
    private static void writeLogsToFireBase(String tag,String message)
    {
        // // TODO: 09/11/16 logic to sync app logs to firebase
    }
}
