package com.beini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by beini on 2017/3/14.
 */
@Controller
@RequestMapping("/")
public class AjaxController {

    @RequestMapping("changeContent")
    public void changeContentMethod(HttpServletRequest request, HttpServletResponse response, PrintWriter printWriter ) {
        System.out.println("-------->changeContentMethod");

        printWriter.write("I  change ");
    }

    /**
     *
     */
    @RequestMapping("ajaxCommit")
    public void ajaxCommitMethod(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("   name=" + request.getParameter("name"));
        System.out.println("   age=" + request.getParameter("age"));

        String personJSON = "{\"name" + "\":\"" + request.getParameter("name") + "\"," + "\"age"
                + "\":" + request.getParameter("age") + "}";

        System.out.println(personJSON);
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
            printWriter.print(personJSON);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != printWriter) {
                printWriter.flush();
                printWriter.close();
            }
        }

    }
}
