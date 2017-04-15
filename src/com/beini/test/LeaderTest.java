package com.beini.test;

import com.beini.bean.Leader;
import com.beini.mapper.LeaderMapper;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beini on 2017/4/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/spring-common.xml")
public class LeaderTest {
    @Autowired
    private LeaderMapper userMapper;


    @org.junit.Test
    public void testFindAll() {
        List<Leader> leaders = new ArrayList<>();
        leaders.add(new Leader("hwh1", 221));
        leaders.add(new Leader("hwh2", 222));
        leaders.add(new Leader("hwh3", 223));
        leaders.add(new Leader("hwh4", 224));
        System.out.println("       start");
        userMapper.insertsLeader(leaders);
        System.out.println("       end");
    }

}
