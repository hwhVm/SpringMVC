package com.beini.mapper;

import com.beini.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * Created by beini on 2017/2/22.
 */

public interface UserMapper {

    @Select("select * from User")
    List<User> getSelectUser();

    @Update("UPDATE User set name=#{name},age=#{age} where id=#{id}")
    void updateUser(User user);

    @Insert("insert into User(name,age) values(#{name},#{age});")
    void insertUser(User user);

    @Delete("DELETE FROM User where id=#{id}")
    int deleteUser(int id);

    @Select("select id id,name name,age age from User where id=#{id}")
    User getUser(int id);

    @Select("select * from  User limit #{start} ,  #{num} ")
    List<User> queryUserInfo(@Param("start")int start,@Param("num")int num);

    @Select("select count(*) from User")
    int getCount();
}
