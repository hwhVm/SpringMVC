package com.beini.test.javase.quote;

import com.beini.utils.BLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beini on 2018/2/1.
 */
public class Test {
    public static List<Phone> phoneList;

    public static void main(String[] args) {
        phoneList = new ArrayList<>();
        PhoneModel phoneModel = new PhoneModel(phoneList);
        BLog.d("     before    " + phoneModel.getPhoneList().size());
        phoneList.add(new Phone());
        phoneList.add(new Phone());
        phoneList.add(new Phone());
        BLog.d("      after   " + phoneModel.getPhoneList().size());

    }
}
