package com.kevin.kggank.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by kevin on 16/4/14.
 */
public class BasePresenter<T extends IBaseView> {

    public T mView;
    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    public BasePresenter(T mView) {
        this.mView = mView;
    }

    public void subscribe(Subscription subscription) {
        if (subscription != null)
            compositeSubscription.add(subscription);
    }

    public T getView(){
        return mView;
    }
}
