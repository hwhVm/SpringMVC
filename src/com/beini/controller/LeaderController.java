package com.beini.controller;

import com.beini.bean.Leader;
import com.beini.controller.exception.GlobaleException;
import com.beini.service.LeaderService;
import com.beini.utils.BLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by beini on 2017/4/15.
 */
@Component
@Controller
@RequestMapping("/")
public class LeaderController {

    @Autowired
    private LeaderService leaderService;

    /**
     * 批量插入
     */
    @RequestMapping("insertUsers")
    public void insertUsers() {

    }


    @RequestMapping("queryAllLeader")
    public void queryAllLeader() throws RuntimeException {
        BLog.d("  queryAllLeader    ");
        List<Leader> leaders = leaderService.queryAll();
        BLog.d("  leaders.size()===" + leaders.size());
        throw new RuntimeException();
    }


}
