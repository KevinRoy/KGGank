package com.kevin.kggank.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.kevin.kggank.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by kevin on 16/4/14.
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    @Nullable
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private boolean isBack = false;

    protected abstract int getLayout();

    protected abstract void initView();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        initToolbar();
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    private void initToolbar() {
        setTitle("");
        setSupportActionBar(toolbar);

        if (isBack()){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    protected boolean isBack(){
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

}
