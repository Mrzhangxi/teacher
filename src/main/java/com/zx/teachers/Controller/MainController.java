package com.zx.teachers.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    /**
     * 首页
     * @return
     */
    @RequestMapping("/")
    public String welcome() {
        return "admin/index";
    }

    /**
     * 显示所有正常老师
     * @return
     */
    @RequestMapping("/usertable")
    public String userTable() {
        return "/admin/usertables";
    }

    /**
     * 修改界面
     * @param id
     * @return
     */
    @RequestMapping("/useredit")
    public ModelAndView userEdit(@RequestParam(value = "id", required = true) Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userId", id);
        modelAndView.setViewName("admin/useredit");
        return modelAndView;
    }
}
