package com.beini.mapper;


import com.beini.bean.Students;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Created by beini on 2017/4/15.
 */
public interface StudentsMapper {
    //查询某个学生的信息
    List<Students> queryStudentByName(@Param("studentName") String studentName);

    //查询tom和mimi的年龄，上几年级,班上多少人
    List<Students> queryTwoStudneByName(@Param("oneName") String oneName, @Param("twoName") String twoName);

    //查询年龄8岁的学生信息
    List<Students> queryStudentByAge(@Param("age") int age);

    //查询__m的学生
    List<Students> queryStudentByIfLastInner(@Param("innerP") String inner);

    //查询%m%的学生
    List<Students> queryStudentByIfLastVague(@Param("vague") String vague);

    //    查询6,8,10年龄的学生,按class_id降序排列,年龄升序排列
    List<Students> queryStudentByIdByOrder(@Param("privIds") List<Integer> privIds);
}
