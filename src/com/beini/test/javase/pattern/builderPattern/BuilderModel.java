package com.beini.test.javase.pattern.builderPattern;

/**
 * Created by beini on 2017/8/14.
 */
public class BuilderModel {
    private String username;
    private int age;
    private String password;

    public static BuilderModel builder(String username, int age) {

        return new BuilderModel(username, age);
    }

    private BuilderModel(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public BuilderModel setPassword(String password) {
        this.password = password;
        return this;
    }

//    public static class Builder {
//        private final String username;
//        private final int age;
//        private  String password;
//
//        public Builder(String username, int age) {
//            this.username = username;
//            this.age = age;
//        }
//
//        public Builder set(String password) {
//            this.password = password;
//            return this;
//        }
//
//        public  BuilderModel builder() {
//            return new BuilderModel(this);
//        }
//    }

//    private BuilderModel(Builder builder) {
//        this.username = builder.username;
//        this.age = builder.age;
//        this.password = builder.password;
//    }

}
