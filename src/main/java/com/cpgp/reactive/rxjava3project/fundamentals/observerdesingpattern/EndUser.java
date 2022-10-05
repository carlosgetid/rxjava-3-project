package com.cpgp.reactive.rxjava3project.fundamentals.observerdesingpattern;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class EndUser implements Observer{
    String name;

    public EndUser(String name, SubjectLibrary subjectLibrary) {
        this.name = name;
        subjectLibrary.subscribeObserver(this);
    }

    @Override
    public void update(String inStock) {
        log.info("Your book is now "+inStock);
    }
}
