package com.beini.test.javase.pattern.observe;

import com.beini.utils.BLog;

/**
 * Created by beini on 2018/2/1.
 */
public class Demo1 extends Observe {

    public Demo1(Subject subject) {
        this.subject = subject;
        this.subject.add(this);
    }

    @Override
    public void update() {
        BLog.d("---Demo1-update----->" + subject.getSate());
    }
}
