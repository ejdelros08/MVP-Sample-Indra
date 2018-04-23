package com.ejdelros08.mvptest.model;

import com.google.gson.Gson;

/**
 * Created by LFT-PC-010 on 5/2/2017.
 */

public class BaseResponseModel<T> {

    private boolean status;
    private String message;
    private T data;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
