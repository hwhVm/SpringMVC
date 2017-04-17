package com.beini.mapper;

import com.beini.bean.Orders;
import com.beini.bean.Person;
import org.apache.ibatis.annotations.Param;

/**
 * Created by beini on 2017/4/15.
 */
public interface OrdersMapper {

    Orders selectOrdersFetchPerson(@Param("id") int id);


}
