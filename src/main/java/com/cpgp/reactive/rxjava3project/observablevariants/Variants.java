package com.cpgp.reactive.rxjava3project.observablevariants;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Variants {

    public static void main(String[] args) {
        Observable<String> observable = Observable
                .just("Alex", "Justin", "Jack");

        observable.first("Name")
                .subscribe(e -> log.info(e));

        Single.just("Alex")
                .subscribe(e -> log.info(e));
    }
}
