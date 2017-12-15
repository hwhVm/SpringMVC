package com.beini.test.javase.decorator;

/**
 * Created by beini on 2017/10/30.
 */
public class DesignViewDecorator implements DrawingInterface {
    DrawingInterface drawingInterface;

    public DesignViewDecorator(DrawingInterface drawingInterface) {
        this.drawingInterface = drawingInterface;
    }

    @Override
    public void onDraw() {
        drawingInterface.onDraw();
    }


}
