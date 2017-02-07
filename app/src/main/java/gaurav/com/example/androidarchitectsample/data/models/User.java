/*
 * Created by Gaurav on 11/11/16 4:17 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 11/11/16 4:17 PM
 */

package gaurav.com.example.androidarchitectsample.data.models;

/**
 * Created by Gaurav on 11/11/16.
 */

public class User {

    String mobile;
    String password;
    String _id;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return "User{" +
                "mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                ", _id='" + _id + '\'' +
                '}';
    }


}
