package com.beini.test.javase.pattern.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beini on 2018/2/1.
 */
public class Subject {
    List<Observe> observes = new ArrayList<>();
    private int sate;


    public void add(Observe observe) {
        observes.add(observe);
    }

    public int getSate() {
        return sate;
    }

    public void setSate(int sate) {
        this.sate = sate;
        notifyAllObserves();
    }

    private void notifyAllObserves() {
        for (Observe o : observes) {
            o.update();
        }
    }


}
