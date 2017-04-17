package com.beini.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by beini on 2017/4/15.
 */
public class Person implements Serializable {
    private Long id;
    private String name;
    private List<Orders> orderList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
