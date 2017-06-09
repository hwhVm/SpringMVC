package com.beini.mapper;

import com.beini.bean.Leader;
import com.beini.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by beini on 2017/4/15.
 */
public interface LeaderMapper {

    //更加id查询
    Leader getLeaderById(int userId);

    //查询全部
    List<Leader> queryAll();

    //批量插入
    void insertsLeader(List<Leader> leaders);

    //插入一个对象
    void insertLeader(Leader leader);

    //删除对象
    void deleteLeader(@Param("id") int id);

    //更新对象
    void updateLeader(Leader leader);

    //批量删除  方法1
    void deletesMethod1(@Param("ids") List<Integer> ids);

    //批量删除  方法2
    void deletesMethod2(@Param("ids") List<Integer> ids);

    //批量更新
    void updatesMethod1(@Param("updatesLeader") List<Leader> leaders);

    List<Leader> doUserLogin(Leader leader);
}
