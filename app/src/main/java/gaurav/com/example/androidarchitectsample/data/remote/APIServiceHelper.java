/*
 * Created by Gaurav on 10/11/16 1:25 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 8/11/16 4:38 PM
 */

package gaurav.com.example.androidarchitectsample.data.remote;

/**
 * Created by Gaurav on 12/16/15.
 */
public class APIServiceHelper {

    public enum ActionType {
        NO_INTERNET,
        START_REQUEST,
        END_REQUEST,
        ERROR
    }

    private String errorMessage;
    private ActionType actionType;

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
