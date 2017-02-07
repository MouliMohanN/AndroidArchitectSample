/*
 * Created by Gaurav on 10/11/16 1:25 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 8/11/16 4:38 PM
 */

package gaurav.com.example.androidarchitectsample.data.remote;


import java.io.IOException;
import java.lang.annotation.Annotation;

import gaurav.com.example.androidarchitectsample.data.models.ApiError;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Gaurav on 7/25/16.
 */
public class ErrorUtils {
    public static ApiError parseError(Response<?> response, Retrofit retrofit) {
        Converter<ResponseBody, ApiError> converter = retrofit.responseBodyConverter(ApiError.class, new Annotation[0]);

        ApiError error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new ApiError();
        }

        return error;
    }
}
