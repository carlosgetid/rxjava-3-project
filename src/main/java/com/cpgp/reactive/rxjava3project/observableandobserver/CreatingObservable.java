package com.cpgp.reactive.rxjava3project.observableandobserver;

import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import java.util.List;

@Slf4j
public class CreatingObservable {
    public static void main(String[] args) {
        Observable<Integer> observable = Observable.create(
                e -> {
                    e.onNext(10);
                    e.onNext(11);
                    e.onNext(12);
                    e.onComplete();
                }
        );

        observable.subscribe(integer -> log.info(String.valueOf(integer)));


        // just
        Observable<Integer> justObservable = Observable.just(1, 2, 3);

        justObservable.subscribe(integer -> log.info(String.valueOf(integer)));


        // fromIterable
        List<String> strings = List.of("Ram", "Shyam", "Mike");

        Observable<String> fromIterableObservable = Observable.fromIterable(strings);

        fromIterableObservable.subscribe(log::info);

    }
}
