package com.beini.test;


import com.beini.bean.Leader;
import com.beini.bean.User;
import com.beini.mapper.LeaderMapper;
import com.beini.mapper.UserMapper;
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
public class UserTest {

	@Autowired
	private LeaderMapper userMapper;


	@Test
	public void testFindAll(){
		List<Leader> findAllList = userMapper.queryAll();
		System.out.println(findAllList.size());
	}

}
