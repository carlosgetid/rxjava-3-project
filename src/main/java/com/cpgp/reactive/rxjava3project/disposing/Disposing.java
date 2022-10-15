package com.cpgp.reactive.rxjava3project.disposing;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Disposing {

    public static void main(String[] args) throws InterruptedException {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);

        log.info("Main thread starts");

        observable.subscribe(new Observer<Long>() {
            private Disposable disposable;

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                this.disposable = d;
            }

            @Override
            public void onNext(@NonNull Long aLong) {
                // not needed
            }

            @Override
            public void onError(@NonNull Throwable e) {
                // not needed
            }

            @Override
            public void onComplete() {
                // not needed
            }
        });

//        TimeUnit.SECONDS.sleep(5);
//
//        disposable.dispose();

        observable.subscribe(e -> log.info("Observer 2: {}", e));

        TimeUnit.SECONDS.sleep(10);
    }
}
