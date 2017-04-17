package com.beini.test.javaee;

import com.beini.bean.Orders;
import com.beini.bean.Person;
import com.beini.mapper.LeaderMapper;
import com.beini.mapper.OrdersMapper;
import com.beini.mapper.PersonMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by beini on 2017/4/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/spring-common.xml")
public class PersonAndOrdersTest {
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    OrdersMapper ordersMapper;

    @org.junit.Test
    public void testPserson() {
        System.out.println("    -------->    start");
        Person personsList = personMapper.selectPersonFetchOrder(1);
        System.out.println("     --------> " + (personsList == null));
        if (personsList != null) {
            System.out.println("   -------->  name=" + personsList.getName() + "   id==" + personsList.getId());
            List<Orders> ordersList = personsList.getOrderList();
            if (ordersList != null) {
                for (Orders orders : ordersList) {
                    System.out.println("            --------------->" + orders.getPrice());
                }
            }
        }
        System.out.println("      -------->  end");
    }

    @org.junit.Test
    public void testOrders() {
        System.out.println("    -------->    start");
        Orders orders = ordersMapper.selectOrdersFetchPerson(1);
        if (orders != null) {
            System.out.println("  ----------->" + orders.getPrice());
            if (orders.getPerson() != null) {
                System.out.println("     "+orders.getPerson().getName());
            }
        }
        System.out.println("    -------->    end");
    }
}
