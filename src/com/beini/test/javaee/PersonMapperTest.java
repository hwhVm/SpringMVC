package com.beini.test.javaee;

import com.beini.bean.Person;
import com.beini.mapper.LeaderMapper;
import com.beini.mapper.PersonMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by beini on 2017/4/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/spring-common.xml")
public class PersonMapperTest {
    @Autowired
    private PersonMapper personMapper;

    @org.junit.Test
    public void test() {
        System.out.println("       start");
        Person person = personMapper.queryOnePerson(1);
        System.out.println("     " + (person == null));
        if (person != null) {
            System.out.println("    " + person.getName() + "   " + person.getOrderList().size());
        }
        System.out.println("       end");
    }

}
