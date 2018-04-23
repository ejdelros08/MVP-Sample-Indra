package com.ejdelros08.mvptest.base;

/**
 * Created by LloydM on 8/18/17
 * for Livefitter
 */

public interface BasePresenter<T> {

    /**
     * Called by the View to let the Presenter know that the UI is ready to receive and display data
     */
    void start();

    void attachView(T view);

    void detachView();
}
