package com.beini.test.javase.extent;

import com.beini.utils.BLog;

/**
 * Created by beini on 2017/10/30.
 */
class Parent {

    String name = "P";

    Parent() {

    }

    Parent(String name) {
        BLog.d(" ---Parent----------->name=" + name);
        BLog.d("  Parent     this.name=" + this.name);
    }

}
