package com.ejdelros08.mvptest.main.login.view;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.ejdelros08.mvptest.R;
import com.ejdelros08.mvptest.base.BaseActivity;
import com.ejdelros08.mvptest.main.login.LoginContract;
import com.ejdelros08.mvptest.main.login.presenter.LoginPresenterImpl;
import com.ejdelros08.mvptest.model.UserModel;
import com.ejdelros08.mvptest.util.DialogUtil;
import com.ejdelros08.mvptest.util.FormFieldTextWatcher;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    private static final String TAG  = LoginActivity.class.getSimpleName();

    @BindView(R.id.toolbar) Toolbar toolbar;

    @BindView(R.id.til_email) TextInputLayout tilEmail;
    @BindView(R.id.til_password) TextInputLayout tilPassword;

    @BindView(R.id.et_email) TextInputEditText etEmail;
    @BindView(R.id.et_password) TextInputEditText etPassword;

    @BindView(R.id.pb_loading) ProgressBar pbLoading;

    @BindView(R.id.btn_login) Button btnLogin;

    private LoginContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        initialize();

    }

    private void initialize() {

        setSupportActionBar(toolbar);

        new LoginPresenterImpl(this);

        mPresenter.attachView(this);

        etEmail.addTextChangedListener(new FormFieldTextWatcher(tilEmail));
        etPassword.addTextChangedListener(new FormFieldTextWatcher(tilPassword));

    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mPresenter != null) {

            mPresenter.attachView(this);

        }

    }

    @Override
    protected void onStop() {
        super.onStop();

        if (mPresenter != null) {

            mPresenter.detachView();

        }

    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {

        mPresenter = presenter;

    }

    @Override
    public void showEmailRequiredError() {

        tilEmail.setError("This field is required");

    }

    @Override
    public void showEmailInvalidError() {

        tilEmail.setError("Invalid Email");

    }

    @Override
    public void showPasswordRequiredError() {

        tilPassword.setError("This field is required");

    }

    @Override
    public void enableViews() {

        etEmail.setEnabled(true);
        etPassword.setEnabled(true);

        btnLogin.setEnabled(true);

    }

    @Override
    public void disableViews() {

        etEmail.setEnabled(false);
        etPassword.setEnabled(false);

        btnLogin.setEnabled(false);

    }

    @Override
    public void showLoading() {

        pbLoading.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideLoading() {

        pbLoading.setVisibility(View.GONE);

    }

    @Override
    public void showLoginError(String message) {

        DialogUtil.showAlertDialog(this, message);

    }

    @OnClick(R.id.btn_login)
    @Override
    public void login() {

        mPresenter.login(etEmail.getText().toString(), etPassword.getText().toString());

    }

    @Override
    public void saveUserAuth(UserModel userModel) {

        //todo save here
        Log.i(TAG, "response: " + userModel.toString());


    }

    @Override
    public void proceedToMainScreen() {

//        Intent intent = new Intent(this,)
//        startActivity(intent);

    }

}
