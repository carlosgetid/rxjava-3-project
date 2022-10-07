package com.cpgp.reactive.rxjava3project.hellorxjava;

import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloRxJava {
    public static void main(String[] args) {
        Observable<String> observable = Observable.create(
                e -> {
                    e.onNext("Hello");
                    e.onNext("RxJava");
                }
        );

        observable.subscribe(e -> log.info("Observer 1: {}", e));
        observable.subscribe(e -> log.info("Observer 2: {}", e));
    }
}
