package com.beini.sql;


/**
 * Created by beini on 2017/2/23.
 * sql构造器
 */
public class SqlStr {

    public String findUserById(int id) {
        return "select id id,name name,age age from User where id=#{id}";
    }
}
