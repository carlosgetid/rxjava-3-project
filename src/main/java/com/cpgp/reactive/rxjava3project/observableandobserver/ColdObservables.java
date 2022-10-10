package com.cpgp.reactive.rxjava3project.observableandobserver;

import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ColdObservables {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(16);
        list.add(17);
        list.add(18);

        Observable<Integer> observable = Observable.fromIterable(list);

        observable.subscribe(e -> log.info(e.toString()));

        list = getData(list);

        observable.subscribe(e -> log.info(e.toString()));
    }

    private static List<Integer> getData(List<Integer> list){
        list.add(19);
        return list;
    }

}
