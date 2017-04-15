package com.beini.test.javaee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by beini on 2017/4/15.
 */
public class SpringTest {

	 public static void main(String[] args) {
		 ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-common.xml");
		 Object userMapper = ctx.getBean("userMapper");
		 System.out.println(userMapper);
	 }
}
