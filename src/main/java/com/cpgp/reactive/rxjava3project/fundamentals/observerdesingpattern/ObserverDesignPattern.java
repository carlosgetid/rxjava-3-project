package com.cpgp.reactive.rxjava3project.fundamentals.observerdesingpattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObserverDesignPattern {

    public static void main(String[] args) {
        Book book = new Book("Goosebumps", "Horror",
                "Xyz", 200, "Sold-out");

        EndUser endUser1 = new EndUser("Bob", book);
        EndUser endUser2 = new EndUser("Rob", book);

        log.info(book.getInStock());

        book.setInStock("In Stock");
    }

}
