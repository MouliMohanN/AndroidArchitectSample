/*
 * Created by Gaurav on 10/11/16 1:25 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 8/11/16 5:58 PM
 */

package gaurav.com.example.androidarchitectsample.data.remote;


import org.greenrobot.eventbus.EventBus;

import gaurav.com.example.androidarchitectsample.data.models.ApiError;
import gaurav.com.example.androidarchitectsample.data.models.BaseResponse;
import gaurav.com.example.androidarchitectsample.util.CL;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Gaurav on 12/2/15.
 */
public class CallbackHandler<T> implements Callback<T> {

    Retrofit mRetrofit;
    private EventBus bus;

    public CallbackHandler(Retrofit retrofit) {
        mRetrofit = retrofit;
        bus = EventBus.getDefault();
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            BaseResponse baseResponse = (BaseResponse) response.body();
            if(baseResponse.isSuccess()) {
                CL.info("Response : " + response.body().toString());
                bus.post(response.body());
                onEndRequest();
            } else {
                onErrorResponse(baseResponse);
            }
        } else {
            ApiError error = ErrorUtils.parseError(response, mRetrofit);
            onErrorResponse(error);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        APIServiceHelper serviceHelper = new APIServiceHelper();
        serviceHelper.setActionType(APIServiceHelper.ActionType.ERROR);
        serviceHelper.setErrorMessage("Fails hitting server.. please try again..");
//        AppLogger.info("onFailure Api Call : " + t.getMessage());
    }


    private void onEndRequest() {
        APIServiceHelper serviceHelper = new APIServiceHelper();
        serviceHelper.setActionType(APIServiceHelper.ActionType.END_REQUEST);
    }

    private void onErrorResponse(BaseResponse baseResponse) {
        APIServiceHelper serviceHelper = new APIServiceHelper();
        serviceHelper.setActionType(APIServiceHelper.ActionType.ERROR);
        serviceHelper.setErrorMessage(baseResponse.getError().getMsg());
        bus.post(serviceHelper);
//        AppLogger.info("Error on Api Call : " + error.toString());
    }

    private void onErrorResponse(ApiError error) {
        APIServiceHelper serviceHelper = new APIServiceHelper();
        serviceHelper.setActionType(APIServiceHelper.ActionType.ERROR);
        serviceHelper.setErrorMessage(error.getMessage());
        bus.post(serviceHelper);
//        AppLogger.info("Error on Api Call : " + error.toString());
    }
}
