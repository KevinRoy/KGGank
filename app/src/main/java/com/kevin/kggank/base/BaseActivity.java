package com.kevin.kggank.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.jakewharton.rxbinding.support.v7.widget.RxToolbar;
import com.kevin.kggank.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by kevin on 16/4/14.
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {

    @Nullable
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private boolean isBack = false;
    private Unbinder unbinder;

    protected abstract int getLayout();

    protected abstract void initView();

    private BasePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        unbinder = ButterKnife.bind(this);
        initToolbar();
        initView();
        presenter = new BasePresenter(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        if (presenter != null) {
            presenter.unAllSubscribe();
        }
    }

    private void initToolbar() {
        setTitle("");
        setSupportActionBar(toolbar);

        if (isBack()) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    protected boolean isBack() {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public Context getContext() {
        return this;
    }
}
