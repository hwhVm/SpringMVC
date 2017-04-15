package com.beini.service;

import com.beini.bean.Leader;

import java.util.List;

/**
 * Created by beini on 2017/4/15.
 */
public interface LeaderService {
    Leader getLeaderById(int userId);

    List<Leader> queryAll();
}
