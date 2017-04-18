package com.beini.test.javaee;

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
    private LeaderMapper leaderMapper;

    @Test
    public void queryAllTest() {
        leaderMapper.queryAll();
    }

    @org.junit.Test
    public void testFindAll() {
//        List<Leader> leaders = new ArrayList<>();
//        leaders.add(new Leader("hwh1", 221));
//        leaders.add(new Leader("hwh2", 222));
//        leaders.add(new Leader("hwh3", 223));
//        leaders.add(new Leader("hwh4", 224));
//        System.out.println("       start");
//        leaderMapper.insertsLeader(leaders);
//        System.out.println("       end");
//        List<Leader> leaderList = leaderMapper.queryAll();
//        System.out.println("      leaderList.size()==" + leaderList.size());
    }

    @org.junit.Test
    public void insertLeaderTest() {
        Leader leader = new Leader();
        leader.setId(48);
        leader.setAge(11);
        leader.setName("lllllll");
//        leaderMapper.insertLeader(leader);
//        leaderMapper.deleteLeader(49);
        leaderMapper.updateLeader(leader);
    }

    /**
     * 批量删除
     */
    @Test
    public void deletesTest() {
        List<Integer> integers = new ArrayList<>();
        integers.add(23);
        integers.add(24);
        leaderMapper.deletesMethod2(integers);
    }

    /**
     * 批量更新
     */
    @Test
    public void updatesMethod1() {
        List<Leader> leaders = new ArrayList<>();
        Leader leader = new Leader();
        leader.setId(25);
        leader.setName("updates1");
        leader.setAge(1);
        leaders.add(leader);

        Leader leader1 = new Leader();
        leader1.setId(26);
        leader1.setName("updates2");
        leader1.setAge(2);
        leaders.add(leader1);

        Leader leader2 = new Leader();
        leader2.setId(27);
        leader2.setName("updates3");
        leader2.setAge(3);
        leaders.add(leader2);

        leaderMapper.updatesMethod1(leaders);
    }
}
