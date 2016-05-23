package com.kevin.kggank.tool;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by kevin on 16/5/22.
 */

public enum RxBus {

    INSTACE;

    private final Subject<Object, Object> _bus = new SerializedSubject<>(PublishSubject.create());

    public void send(Object o) {
        if (hasObservers()) {
            try {
                _bus.onNext(o);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Observable<Object> toObserverable() {
        return _bus.observeOn(AndroidSchedulers.mainThread());
    }

    public boolean hasObservers() {
        return _bus.hasObservers();
    }
}
