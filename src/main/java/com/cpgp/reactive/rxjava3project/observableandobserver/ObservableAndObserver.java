package com.cpgp.reactive.rxjava3project.observableandobserver;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObservableAndObserver {
    public static void main(String[] args) {
        Observable<Integer> observable = new ObservableCreate<Integer>(new ObservableOnSubscribe<Integer>(){
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
                try{
                    emitter.onNext(10);
                    emitter.onNext(11);
                    emitter.onComplete();
                }
                catch(Exception exception){
                    emitter.onError(exception);
                }
            }
        });

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                log.info("Subscribed");
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                log.info("On Next: {}", integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                log.error("Error: {}", e.getMessage());
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                log.info("Completed");
            }
        };

        observable.subscribe(observer);
    }
}
