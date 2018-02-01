package com.beini.test.javase.quote;

import java.util.List;

/**
 * Created by beini on 2018/2/1.
 */
public class PhoneModel {

    private List<Phone> phoneList;

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public PhoneModel(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }


}
