package com.cpgp.reactive.rxjava3project.disposing;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Disposing {

    private static final CompositeDisposable COMPOSITE_DISPOSABLE = new CompositeDisposable();

    public static void main(String[] args) throws InterruptedException {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);

        log.info("Main thread starts");

        Disposable disposable1 = observable.subscribe(e -> log.info("Observer 1: {}", e));
        Disposable disposable2 = observable.subscribe(e -> log.info("Observer 2: {}", e));

        TimeUnit.SECONDS.sleep(5);

        COMPOSITE_DISPOSABLE.addAll(disposable1, disposable2);

        COMPOSITE_DISPOSABLE.dispose();

        TimeUnit.SECONDS.sleep(10);
    }
}
