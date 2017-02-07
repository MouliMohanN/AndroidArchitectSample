/*
 * Created by Gaurav on 20/11/16 4:15 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 20/11/16 4:15 PM
 */

package gaurav.com.example.androidarchitectsample.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.google.common.base.Strings;

/**
 * Created by Gaurav on 20/11/16.
 */


public class TextWatcherUtil implements TextWatcher {
    @Nullable
    TextInputLayout til;
    @NonNull
    EditText et;
    @NonNull
    String error;

    public TextWatcherUtil(@Nullable TextInputLayout til, @NonNull EditText et, @Nullable String message) {
        this.til = til;
        this.et = et;
        error = message;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (Strings.isNullOrEmpty(et.getText().toString())) {
            til.setErrorEnabled(true);
            if(!Strings.isNullOrEmpty(error))
                    til.setError(error);
        }
        else {
            til.setErrorEnabled(false);
        }

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}

