package com.beini.bean;

/**
 * Created by beini on 2017/4/15.
 */
public class Orders {
    private int id;
    private double price;
    private Person person;

    public Orders(double price, Person person) {
        this.price = price;
        this.person = person;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
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
