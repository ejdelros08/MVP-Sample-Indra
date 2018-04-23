package com.ejdelros08.mvptest.main.login;

import com.ejdelros08.mvptest.base.BasePresenter;
import com.ejdelros08.mvptest.base.BaseView;
import com.ejdelros08.mvptest.model.UserModel;

/**
 * Created by EJ Del Rosario
 * April 23 2018
 * -----------------------------------------------
 * ejdelros08@gmail.com | dev.ejdelros08@gmail.com
 */
public interface LoginContract {

    interface View extends BaseView<Presenter> {

        void showEmailRequiredError();

        void showEmailInvalidError();

        void showPasswordRequiredError();

        void enableViews();

        void disableViews();

        void showLoading();

        void hideLoading();

        void showLoginError(String message);

        void login();

        void saveUserAuth(UserModel userModel);

        void proceedToMainScreen();

    }

    interface Presenter extends BasePresenter<View> {

        void login(String email, String password);

        boolean isValid(String email, String password);

    }

}
