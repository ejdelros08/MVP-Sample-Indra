package com.ejdelros08.mvptest.base;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.ejdelros08.mvptest.AppConstants;

/**
 * Created by LFT-PC-010 on 10/11/2017.
 */

public class BaseActivity extends AppCompatActivity {

    public void switchActivity(Intent intent, boolean finish){

        startActivity(intent);

        if(finish){
            finish();
        }
    }

    public void switchActivity(Class<?> cls, boolean finish){

        Intent intent = new Intent(this, cls);

        switchActivity(intent, finish);

    }

    public void switchFragment(Fragment frag, int container, String tag, boolean addToBackStack, boolean clearBackStack){
        AppConstants.FRAG_CURRENT = tag;
        if(clearBackStack){
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
        if(addToBackStack){
            getSupportFragmentManager().beginTransaction().replace(container, frag, tag).addToBackStack(tag).commit();
        }
        else {
            getSupportFragmentManager().beginTransaction().replace(container, frag, tag).commit();
        }
    }

    public void showSoftKeyboard(View editText){
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(editText, InputMethodManager.SHOW_FORCED);
    }

    public void hideSoftKeyboard() {
        if(getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    public void hideSoftKeyboard(View view) {
        if(getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}
