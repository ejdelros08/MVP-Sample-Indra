package com.ejdelros08.mvptest.base;

/**
 * Created by LFT-PC-010 on 10/19/2017.
 */

public interface BaseCallback<T> {

    void onCacheLoaded(T cache);

    void onSuccess(T response);

    void onError(String message);

}
