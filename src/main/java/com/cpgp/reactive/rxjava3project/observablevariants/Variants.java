package com.cpgp.reactive.rxjava3project.observablevariants;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Variants {

    public static void main(String[] args) {
        Completable completable = Completable.complete();
        completable.subscribe(()-> log.info("Completed"));

        Completable
                .fromRunnable(() -> log
                        .info("Some process executing"))
                .subscribe(() -> log
                        .info("The process executed successfully"));



    }
}
