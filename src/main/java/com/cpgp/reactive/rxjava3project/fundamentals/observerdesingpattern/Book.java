package com.cpgp.reactive.rxjava3project.fundamentals.observerdesingpattern;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@RequiredArgsConstructor
@Getter
@Slf4j
public class Book implements SubjectLibrary{
    private String name;
    private String type;
    private String author;
    private double price;
    private String inStock;
    private ArrayList<Observer> observers = new ArrayList<>();

    public Book(String name, String type, String author, double price, String inStock) {
        this.name = name;
        this.type = type;
        this.author = author;
        this.price = price;
        this.inStock = inStock;
    }

    @Override
    public void subscribeObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        log.info(toString());
        observers.forEach(observer -> observer.update(inStock));
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setInStock(String inStock) {
        this.inStock = inStock;
        log.info("Availability change from sold-out to back in stock");
        notifyObserver();
    }

    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", inStock='" + inStock + '\'' +
                ", observers=" + observers +
                '}';
    }
}
