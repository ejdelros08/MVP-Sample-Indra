package com.ejdelros08.mvptest.data;

import com.ejdelros08.mvptest.AppConstants;
import com.ejdelros08.mvptest.model.BaseResponseModel;
import com.ejdelros08.mvptest.model.UserModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by EJ Del Rosario
 * April 23 2018
 * -----------------------------------------------
 * ejdelros08@gmail.com | dev.ejdelros08@gmail.com
 */
public interface UserApiMethods {

    @Headers({
            "Accept: application/json",
            "Content-type: application/json",
    })
    @GET(AppConstants.URL_LOG_IN)
    Call<BaseResponseModel<UserModel>> login();

}
