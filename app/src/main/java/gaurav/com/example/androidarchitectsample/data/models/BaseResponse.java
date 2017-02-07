/*
 * Created by Gaurav on 11/11/16 4:04 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 11/11/16 4:04 PM
 */

package gaurav.com.example.androidarchitectsample.data.models;

/**
 * Created by Gaurav on 11/11/16.
 */

public class BaseResponse {

    boolean success;
    RemoteError error;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public RemoteError getError() {
        return error;
    }

    public void setError(RemoteError error) {
        this.error = error;
    }
}
