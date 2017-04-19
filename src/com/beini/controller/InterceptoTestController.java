package com.beini.controller;

import com.beini.utils.BLog;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by beini on 2017/4/19.
 */
@Component
@Controller
@RequestMapping("/test/")
public class InterceptoTestController {

    @RequestMapping("user")
    private void testIntercepto() {
        BLog.d(" testIntercepto ");
    }
}
