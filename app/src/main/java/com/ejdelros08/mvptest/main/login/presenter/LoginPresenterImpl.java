package com.ejdelros08.mvptest.main.login.presenter;

import com.ejdelros08.mvptest.base.BaseCallback;
import com.ejdelros08.mvptest.main.login.LoginContract;
import com.ejdelros08.mvptest.main.login.model.LoginService;
import com.ejdelros08.mvptest.main.login.model.LoginServiceImpl;
import com.ejdelros08.mvptest.model.UserModel;

/**
 * Created by EJ Del Rosario
 * April 23 2018
 * -----------------------------------------------
 * ejdelros08@gmail.com | dev.ejdelros08@gmail.com
 */
public class LoginPresenterImpl implements LoginContract.Presenter {

    private LoginContract.View mView;

    private LoginService mService;

    public LoginPresenterImpl(LoginContract.View view){

        view.setPresenter(this);

        mService = new LoginServiceImpl();

    }

    @Override
    public void start() {

    }

    @Override
    public void attachView(LoginContract.View view) {

        mView = view;

    }

    @Override
    public void detachView() {

        mView = null;

    }

    @Override
    public void login(String email, String password) {

        if (isValid(email, password)) {

            if (mView != null) {

                mView.disableViews();

                mView.showLoading();

                mService.doLogin(email, password, new BaseCallback<UserModel>() {

                    @Override
                    public void onCacheLoaded(UserModel cache) {
                        //we will not use this
                    }

                    @Override
                    public void onSuccess(UserModel userModel) {

                        if (mView != null) {

                            mView.hideLoading();

                            mView.enableViews();

                            mView.saveUserAuth(userModel);

                            mView.proceedToMainScreen();

                        }


                    }

                    @Override
                    public void onError(String message) {

                        if (mView != null) {

                            mView.hideLoading();

                            mView.enableViews();

                            mView.showLoginError(message);

                        }


                    }
                });

            }

        }

    }

    @Override
    public boolean isValid(String email, String password) {
        boolean isValid = true;

        if (email == null || email.length() == 0) {

            isValid = false;

            mView.showEmailRequiredError();

        }

        if (password == null || password.length() == 0) {

            isValid = false;

            mView.showPasswordRequiredError();

        }

        return isValid;

    }

}
