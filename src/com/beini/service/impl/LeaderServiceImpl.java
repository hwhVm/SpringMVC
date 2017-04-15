package com.beini.service.impl;

import com.beini.bean.Leader;
import com.beini.bean.User;
import com.beini.mapper.LeaderMapper;
import com.beini.mapper.UserMapper;
import com.beini.service.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by beini on 2017/4/15.
 */
@Service
public class LeaderServiceImpl implements LeaderService {

    @Autowired
    LeaderMapper leaderMapper;

    @Override
    public Leader getLeaderById(int userId) {
        return leaderMapper.getLeaderById(userId);
    }

    @Override
    public List<Leader> queryAll() {
        return leaderMapper.queryAll();
    }

    @Override
    public void inserUsers(List<Leader> leaders) {
        leaderMapper.insertsLeader(leaders);
    }
}
