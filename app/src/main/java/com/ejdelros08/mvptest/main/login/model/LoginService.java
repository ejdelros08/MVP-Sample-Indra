package com.ejdelros08.mvptest.main.login.model;

import com.ejdelros08.mvptest.base.BaseCallback;
import com.ejdelros08.mvptest.model.UserModel;

/**
 * Created by EJ Del Rosario
 * April 23 2018
 * -----------------------------------------------
 * ejdelros08@gmail.com | dev.ejdelros08@gmail.com
 */
public interface LoginService {

    void doLogin(String email, String password, BaseCallback<UserModel> callback);

}
