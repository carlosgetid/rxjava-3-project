package com.cpgp.reactive.rxjava3project.fundamentals.pushvspull;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class CallBackDemo {

    public static void main(String[] args) throws InterruptedException {
        log.info("Main Thread is running");

        Runnable runnable = () -> new CallBackDemo().runningAsync(new CallBack() {
            @Override
            public void pushComplete() {
                log.info("Callback done!");
            }

            @Override
            public void pushData(String data) {
                log.info("Callback data: " + data);
            }

            @Override
            public void pushError(Exception exception) {
                log.error("Callback Error called, Got an exception: " + exception);
            }
        });

        Thread thread = new Thread(runnable);
        thread.start();
        TimeUnit.SECONDS.sleep(5);
        log.info("past 5 seconds");
        TimeUnit.SECONDS.sleep(20);
        log.info("past 20 seconds");

        log.info("Main Thread Completed");

    }

    public void runningAsync(CallBack callBack) {
        log.info("I am running in separate Thread");
        sleep(10);
        log.info("past 10 minutes");
        callBack.pushData("Data1");
        callBack.pushData("Data2");
        callBack.pushData("Data3");

        callBack.pushError(new RuntimeException("Oops!"));
        callBack.pushComplete();
        sleep(17);
        log.info("past 17 seconds");
    }

    private void sleep(int duration) {
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException interruptedException) {
            log.error("InterruptedException: ", interruptedException);
            Thread.currentThread().interrupt();
        }

    }
}
