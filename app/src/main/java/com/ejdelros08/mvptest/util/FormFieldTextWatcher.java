package com.ejdelros08.mvptest.util;

import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;


/**
 * Created by LloydM on 2/9/17
 * for Livefitter
 */

public class FormFieldTextWatcher implements TextWatcher {

    protected TextInputLayout mTextInputLayout;

    public FormFieldTextWatcher(TextInputLayout textInputLayout) {
        this.mTextInputLayout = textInputLayout;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
        if(mTextInputLayout != null){
            mTextInputLayout.setError(null);
            mTextInputLayout.setErrorEnabled(false);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
