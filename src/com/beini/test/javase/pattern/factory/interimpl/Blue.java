package com.beini.test.javase.pattern.factory.interimpl;

import com.beini.test.javase.pattern.factory.inter.Color;

/**
 * Created by beini on 2017/12/15.
 */
public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println(" Blue Color");
    }
}
