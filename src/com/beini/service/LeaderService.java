package com.beini.service;

import com.beini.bean.Leader;
import com.beini.bean.User;

import java.util.List;

/**
 * Created by beini on 2017/4/15.
 */
public interface LeaderService {
    Leader getLeaderById(int userId);

    List<Leader> queryAll();

    void inserUsers(List<Leader> users);

    List<Leader> doUserLogin(Leader user);
}
