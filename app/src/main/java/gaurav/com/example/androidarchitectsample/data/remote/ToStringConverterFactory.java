/*
 * Created by Gaurav on 10/11/16 1:25 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 8/11/16 4:38 PM
 */

package gaurav.com.example.androidarchitectsample.data.remote;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by Gaurav on 8/1/16.
 */
public class ToStringConverterFactory extends Converter.Factory {
    private static final MediaType MEDIA_TYPE = MediaType.parse("text/plain");


    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (String.class.equals(type)) {
            return new Converter<ResponseBody, String>() {
                @Override
                public String convert(ResponseBody value) throws IOException {
                    return value.string();
                }
            };
        }
        return null;
    }

    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {

        if (String.class.equals(type)) {
            return new Converter<String, RequestBody>() {
                @Override
                public RequestBody convert(String value) throws IOException {
                    return RequestBody.create(MEDIA_TYPE, value);
                }
            };
        }
        return null;
    }
}
