package com.cpgp.reactive.rxjava3project.fundamentals.callbackhell;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CallBackDemo {

    public static void main(String[] args) throws InterruptedException {
        log.info("Main Thread is running");

        Runnable runnable = () -> new CallBackDemo()
                .runningAsync(() -> log.info("Callback called!"));

        Thread thread = new Thread(runnable);
        thread.start();

        Thread.sleep(20000);

        log.info("Main Thread Completed");

    }

    public void runningAsync(CallBack callBack) {
        log.info("I am running in separate Thread");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
        callBack.call();
    }
}
