package com.cpgp.reactive.rxjava3project.observableandobserver;

import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreatingObserver {

    public static void main(String[] args) {
        Observable<String> observable = Observable.just("Orange", "Black", "Red");

        observable.subscribe(
                log::info,
                Throwable::printStackTrace,
                () -> log.info("Completed")
                );

        observable.subscribe(
                log::info,
                Throwable::printStackTrace
        );

        observable.subscribe(
                log::info
        );
    }

}
