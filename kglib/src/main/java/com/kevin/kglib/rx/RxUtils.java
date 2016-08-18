package com.kevin.kglib.rx;

import android.text.TextUtils;
import android.widget.EditText;

import com.jakewharton.rxbinding.widget.RxTextView;
import com.kevin.kglib.R;
import com.kevin.kglib.utils.ContextUtils;

import java.util.concurrent.TimeUnit;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by kevin on 16/8/16.
 */

public class RxUtils {

    public static final int MAXSIZE = 100;

    /**
     * 限制输入框字的长度
     * @param editText
     * @return
     */
    public static Subscription limitInput(EditText editText) {
        return RxTextView.textChanges(editText)
                .map(charSequence -> {
                    if (!TextUtils.isEmpty(charSequence) && charSequence.length() > MAXSIZE) {
                        editText.setText(charSequence.toString().substring(0, MAXSIZE));
                        editText.setSelection(MAXSIZE);
                    }
                    return charSequence;
                })
                .debounce(1000, TimeUnit.MILLISECONDS)
                .map(charSequence1 -> {
                    if (charSequence1.length() > MAXSIZE) {
                        return String.format(ContextUtils.appContext.getString(R.string.limit_input_size), MAXSIZE);
                    } else {
                        return null;
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    editText.setError(s);
                });
    }
}
