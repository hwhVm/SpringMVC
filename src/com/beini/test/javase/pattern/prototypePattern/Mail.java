package com.beini.test.javase.pattern.prototypePattern;

/**
 * Created by beini on 2018/2/6.
 */
public class Mail implements Cloneable {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Mail(String title) {
        this.title = title;
    }

    /**
     * 浅拷贝
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Mail clone() throws CloneNotSupportedException {
        return (Mail) super.clone();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Mail cloneObject = (Mail) obj;
        boolean result = cloneObject.getTitle().equals(this.getTitle());
        return result;
    }

}
