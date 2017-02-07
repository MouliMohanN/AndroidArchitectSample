/*
 * Created by Gaurav on 11/11/16 4:07 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 11/11/16 4:07 PM
 */

package gaurav.com.example.androidarchitectsample.data.models;

/**
 * Created by Gaurav on 11/11/16.
 */

public class RemoteError {

    private String msg;
    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "RemoteError{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                '}';
    }
}
