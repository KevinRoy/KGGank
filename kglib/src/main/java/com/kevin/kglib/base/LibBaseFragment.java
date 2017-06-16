package com.kevin.kglib.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by kevin on 16/6/18.
 */

public abstract class LibBaseFragment<T> extends Fragment implements LibIBaseView {

    private Unbinder unbinder;
    private View rootView;
    private LibBasePresenter presenter;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public void addSubscribe(Disposable disposable) {
        if (compositeDisposable != null)
            compositeDisposable.add(disposable);
    }

    public void unAllSubscribe() {
        if (compositeDisposable != null)
            compositeDisposable.clear();
    }

    protected abstract int getLayout();

    protected abstract void initView();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getLayout(), container, false);
            unbinder = ButterKnife.bind(this, rootView);
        }

        ViewGroup parent = (ViewGroup) rootView.getParent();

        if (parent != null) {
            parent.removeView(rootView);
        }

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        presenter = new LibBasePresenter(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        unAllSubscribe();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null)
            unbinder.unbind();
    }

    @Override
    public Context getContext() {
        return getActivity();
    }
}
