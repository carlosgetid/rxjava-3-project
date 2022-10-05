package com.cpgp.reactive.rxjava3project.fundamentals.observerdesingpattern;

@FunctionalInterface
public interface Observer {
    void update(String inStock);
}