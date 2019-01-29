package com.zx.teachers.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeacherController {

    @RequestMapping("/")
    public String welcome() {
        return "teacher/index";
    }
}
