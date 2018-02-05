package com.beini.test.javase.pattern.strategy;

/**
 * Created by beini on 2018/2/5.
 */
public class DoOperationReduce implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
