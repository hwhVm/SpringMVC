package com.beini.test.javase.pattern.observe;

import com.beini.utils.BLog;

/**
 * Created by beini on 2018/2/1.
 */
public class Demo3 extends Observe {

    public Demo3(Subject subject) {
        this.subject = subject;
        this.subject.add(this);
    }

    @Override
    public void update() {
        BLog.d("---Demo3-update----->" + subject.getSate());
    }
    
}
