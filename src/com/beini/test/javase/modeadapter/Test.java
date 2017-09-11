package com.beini.test.javase.modeadapter;

/**
 * Created by beini on 2017/9/11.
 */
public class Test {

    public static void main(String[] args) {
        MacComputer macComputer = new MacComputer();
//        Line  line=new Line();
//        macComputer.setInterface(line);
//        macComputer.chakou();

        HdLineAdapter baseAdapter = new HdLineAdapter();
        macComputer.setInterface(baseAdapter);
        macComputer.chakou();

    }
}
