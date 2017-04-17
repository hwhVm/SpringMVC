package com.beini.mapper;


import com.beini.bean.ClassBean;
import org.apache.ibatis.annotations.Param;

/**
 * Created by beini on 2017/4/15.
 */
public interface ClassBeanMapper {
    //查询一年级的学生信息
    ClassBean queryClassById(@Param("id") int id);

}
