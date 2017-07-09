package com.kevin.kglib.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by kevin on 16/6/18.
 */

public abstract class LibBaseActivity extends AppCompatActivity implements LibIBaseView {

    private LibBasePresenter presenter;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    protected abstract int getLayout();

    protected abstract void initView();

    public void addSubscribe(Disposable disposable) {
        if (compositeDisposable != null)
            compositeDisposable.add(disposable);
    }

    public void unAllSubscribe() {
        if (compositeDisposable != null)
            compositeDisposable.clear();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
        presenter = new LibBasePresenter(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.unAllSubscribe();
        }

        unAllSubscribe();
    }

    @Override
    public Context getContext() {
        return this;
    }
}
