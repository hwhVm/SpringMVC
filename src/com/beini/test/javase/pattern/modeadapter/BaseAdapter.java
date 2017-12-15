package com.beini.test.javase.pattern.modeadapter;

import com.beini.test.javase.pattern.modeadapter.iface.Hdinterface;
import com.beini.test.javase.pattern.modeadapter.iface.VVIntface;

/**
 * Created by beini on 2017/9/11.
 */
public class BaseAdapter extends Line implements Hdinterface, VVIntface {

    @Override
    public void SvgPower() {
        super.SvgPower();
    }

    @Override
    public void hdPower() {
        System.out.println("显示  hdPower");
    }

    @Override
    public void vv() {
        System.out.println("显示  vv");
    }
}
