package com.kevin.kggank.base;

import android.content.Context;

import com.kevin.kggank.ui.view.IMainView;

import retrofit2.http.PUT;
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

    public void addSubscribe(Subscription subscription) {
        if (subscription != null)
            compositeSubscription.add(subscription);
    }

    public void unSubscribe() {
        if (compositeSubscription.hasSubscriptions() || !compositeSubscription.isUnsubscribed()) {
            compositeSubscription.clear();
        }
    }

    public T getView() {
        return mView;
    }

    public Context getContext() {
        return mView.getContext();
    }
}
