package com.beini.test.javase.pattern.modeadapter;

import com.beini.test.javase.pattern.modeadapter.iface.SvgInterface;

/**
 * Created by beini on 2017/9/11.
 */
public class MacComputer {
    SvgInterface svgInterface;

    public void setInterface(SvgInterface svgInterface) {
        this.svgInterface = svgInterface;
    }

    void chakou() {
        svgInterface.SvgPower();
    }

}
