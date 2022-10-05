package com.cpgp.reactive.rxjava3project.fundamentals.pushvspull;

public interface CallBack {
    void pushComplete();

    void pushData(String data);

    void pushError(Exception exception);
}
