package com.beini.bean;

import java.io.Serializable;

/**
 * Created by beini on 2017/4/15.
 */
public class Orders implements Serializable {
    private Long id;
    private double price;
    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
