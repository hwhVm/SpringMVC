package com.beini.mapper;

import com.beini.bean.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by beini on 2017/4/15.
 */
public interface PersonMapper {
    Person selectPersonFetchOrder(@Param("id") int id);

    List<Person> findAll();

    List<Person> finadAllaboutOrders();

    List<Person> queryForList();
}
