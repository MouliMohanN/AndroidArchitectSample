/*
 * Created by Gaurav on 10/11/16 1:25 PM
 * Copyright (c) 2016. All rights reserved
 *
 * Last Modified 8/11/16 4:29 PM
 */

package gaurav.com.example.androidarchitectsample.util;

/**
 * Created by Gaurav on 07/11/16.
 */

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * In Dagger, an unscoped component cannot depend on a scoped component. As
 * {@link gaurav.com.example.androidarchitectsample.data.remote.CSRepositoryComponent} is a scoped component ({@code @Singleton}, we create a custom
 * scope to be used by all fragment components. Additionally, a component with a specific scope
 * cannot have a sub component with the same scope.
 */
@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface FragmentScoped {
}
