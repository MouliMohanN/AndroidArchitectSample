/*
 * Created by Gaurav on 10/11/16 1:25 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 10/11/16 1:17 PM
 */

package gaurav.com.example.androidarchitectsample.data.local;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Gaurav on 10/11/16.
 */

public class PreferenceManager {
    private  String SHARED_PREFRENCE_FILE = "cardstel";
    private SharedPreferences prefs;

    public PreferenceManager(Application application){
        prefs = application.getSharedPreferences(SHARED_PREFRENCE_FILE, Context.MODE_PRIVATE);
    }

    public  void storeValue(Context context, String key, Object value) {

        if (context != null) {
            SharedPreferences.Editor editor = prefs.edit();
            if (value instanceof String) {
                editor.putString(key, (String) value);
            } else if (value instanceof Integer) {
                editor.putInt(key, (Integer) value);
            } else if (value instanceof Boolean) {
                editor.putBoolean(key, (Boolean) value);
            }else if (value instanceof Long) {
                editor.putLong(key, (Long) value);
            }

            editor.apply();
        }
    }

    public  String getStringValue(Context context, String key) {
        return prefs.getString(key, "");
    }

    public  boolean getBooleanValue(Context context, String key) {
        return prefs.getBoolean(key, false);
    }

    public  int getIntegerValue(Context context, String key) {
        return prefs.getInt(key, 0);
    }

    public  float getIntegerFloat(Context context, String key) {
        return prefs.getFloat(key, 0);
    }

    public  void clearAllPreferences(Context context) {
        prefs.edit().clear().apply();
    }

    public  long getLongValue(Context context, String key) {
        return prefs.getLong(key, 0);
    }
}
