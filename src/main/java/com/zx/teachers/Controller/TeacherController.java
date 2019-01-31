package com.zx.teachers.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeacherController {

    @RequestMapping("/")
    public String welcome() {
        return "teacher/index";
    }

    @RequestMapping("/templates")
    public String templates() {
        return "teacher/templates";
    }

    @RequestMapping("/userlogin")
    public String userlogin() {
        return "userlogin";
    }
}
