package com.beini.controller;

import com.beini.service.LeaderService;
import com.beini.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by beini on 2017/6/9.
 */
@Controller
public class BaseController {

    @Autowired(required = false)
    public UserService userService;

    @Autowired(required = false)
    public LeaderService leaderService;
}
