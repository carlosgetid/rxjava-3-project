package com.cpgp.reactive.rxjava3project.fundamentals;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;

@Slf4j
public class CallBackDemo {

    public static void main(String[] args) throws InterruptedException {
        log.info("Main Thread is running");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new CallBackDemo().runningAsync(new CallBack() {
                    @Override
                    public void call() {
                        log.info("Callback called!");
                    }
                });
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        Thread.sleep(20000);

        log.info("Main Thread Completed");

    }

    public void runningAsync(CallBack callBack) {
        log.info("I am running in separate Thread");
        sleep(10000);
        callBack.call();
    }

    private void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException interruptedException) {
            log.error("InterruptedException: ", interruptedException);
            Thread.currentThread().interrupt();
        }

    }
}
