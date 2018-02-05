package com.beini.test.javase.gc;

/**
 * Created by beini on 2017/4/18.
 */
public class User implements Comparable<User> {
    private String name;
    private int age;


    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        User student = (User) obj;
        if (!student.getName().equals(getName())) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(User user) {
        //        0表示两个对象相等，返回正数表示大于，返回负数表示小于
        return this.age - user.age;
    }


}
