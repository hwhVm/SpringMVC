package com.beini.test.javase;

/**
 * Created by beini on 2017/4/26.
 */
public class InnerClass {

    static DemoHandler demoHandler = new DemoHandler() {
        @Override
        public void handleMessage() {
            super.handleMessage();
        }
    };

    public static void main(String[] args) {


    }

}
