package com.beini.test.javase.decorator;

/**
 * Created by beini on 2017/10/30.
 */
public class EleventDesignView extends DesignViewDecorator {

    public EleventDesignView(DrawingInterface drawingInterface) {
        super(drawingInterface);
    }

    public void onDraw() {
        drawingInterface.onDraw();
    }
}
