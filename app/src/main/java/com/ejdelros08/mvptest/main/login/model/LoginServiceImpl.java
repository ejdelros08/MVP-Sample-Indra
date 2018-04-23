package com.ejdelros08.mvptest.main.login.model;

import com.ejdelros08.mvptest.data.UserApiMethods;
import com.ejdelros08.mvptest.model.BaseResponseModel;
import com.ejdelros08.mvptest.model.UserModel;
import com.ejdelros08.mvptest.util.RetrofitUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by EJ Del Rosario
 * April 23 2018
 * -----------------------------------------------
 * ejdelros08@gmail.com | dev.ejdelros08@gmail.com
 */
public class LoginServiceImpl implements LoginService {


    @Override
    public void doLogin(String email, String password, final LoginCallback callback) {

        UserApiMethods apiMethods = RetrofitUtil.getGSONRetrofit().create(UserApiMethods.class);

        apiMethods.login().enqueue(new Callback<BaseResponseModel<UserModel>>() {
            @Override
            public void onResponse(Call<BaseResponseModel<UserModel>> call, Response<BaseResponseModel<UserModel>> response) {

                if (response.isSuccessful()) {

                    if (response.body().getStatus()) {

                        callback.onSuccess(response.body().getData());

                    }
                    else{

                        callback.onError(response.body().getMessage());

                    }

                }
                else{

                    callback.onError(null);

                }

            }

            @Override
            public void onFailure(Call<BaseResponseModel<UserModel>> call, Throwable t) {

            }
        });

    }


}
