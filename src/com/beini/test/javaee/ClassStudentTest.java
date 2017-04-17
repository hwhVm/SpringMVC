package com.beini.test.javaee;

import com.beini.bean.ClassBean;
import com.beini.bean.Students;
import com.beini.mapper.ClassBeanMapper;
import com.beini.mapper.LeaderMapper;
import com.beini.mapper.StudentsMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by beini on 2017/4/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/spring-common.xml")
public class ClassStudentTest {
    @Autowired
    private ClassBeanMapper classBeanMapper;
    @Autowired
    private StudentsMapper studentsMapper;


    @org.junit.Test
    public void queryClassByIdTest() {
        ClassBean classBean = classBeanMapper.queryClassById(1);
        if (classBean != null) {
            System.out.println("  -->students.size()== " + classBean.getStdudents().size() + "    " + classBean.getGrade());
            for (Students students : classBean.getStdudents()) {
                System.out.println(" ---->   " + students.getName());
            }
        }
    }

    @org.junit.Test
    public void queryStudentByNameTest() {
        List<Students> students = studentsMapper.queryStudentByName("tom");
        System.out.println("     " + students.size());
        for (Students student : students) {
            System.out.println(" ---->   " + student.getName());
        }
    }

    @org.junit.Test
    public void queryTwoStudneByNameTest() {
        List<Students> students = studentsMapper.queryTwoStudneByName("tom", "mimi");
        System.out.println("    " + students.size());
        for (Students students1 : students) {
            System.out.println(" ---->   " + students1.getName());
        }
    }

    @Test
    public void queryStudentByIdByOrder() {
        List<Integer> integers = new ArrayList<>();
        integers.add(6);
        integers.add(7);
        integers.add(8);
        List<Students> students = studentsMapper.queryStudentByIdByOrder(integers);
        System.out.println("   --------->" + students.size());
        for (Students students1 : students) {
            System.out.println(" ---->   " + students1.getName());
        }
    }
}
