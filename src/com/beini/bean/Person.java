package com.beini.bean;

import java.util.List;

/**
 * Created by beini on 2017/4/15.
 */
public class Person {
    private int id;
    private String name;
    private List<Orders> orderList;

    public Person(String name, List<Orders> orderList) {
        this.name = name;
        this.orderList = orderList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Orders> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Orders> orderList) {
        this.orderList = orderList;
    }
}
