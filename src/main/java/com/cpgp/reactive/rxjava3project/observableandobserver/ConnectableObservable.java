package com.cpgp.reactive.rxjava3project.observableandobserver;


import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class ConnectableObservable {

    public static void main(String[] args) throws InterruptedException {
        int period = 1;
        io.reactivex.rxjava3.observables.ConnectableObservable<Long> connectableObservable
                = Observable.interval(period, TimeUnit.SECONDS).publish();

        connectableObservable.connect();

        connectableObservable.subscribe(e -> log.info(e.toString()));

        TimeUnit.SECONDS.sleep(10);

        connectableObservable.subscribe(e -> log.info(e.toString()));

        TimeUnit.SECONDS.sleep(10);
    }
}
