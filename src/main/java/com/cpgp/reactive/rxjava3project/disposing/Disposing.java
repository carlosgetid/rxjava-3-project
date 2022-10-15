package com.cpgp.reactive.rxjava3project.disposing;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Disposing {

    public static void main(String[] args) throws InterruptedException {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);

        log.info("Main thread starts");

        Disposable disposable = observable.subscribe(e -> log.info("Observer 1: {}", e));

        TimeUnit.SECONDS.sleep(5);

        disposable.dispose();

        observable.subscribe(e -> log.info("Observer 2: {}", e));

        TimeUnit.SECONDS.sleep(10);
    }
}
