package com.cpgp.reactive.rxjava3project.fundamentals.observerdesingpattern;

public interface SubjectLibrary {
    void subscribeObserver(Observer observer);
    void unsubscribeObserver(Observer observer);
    void notifyObserver();
}
