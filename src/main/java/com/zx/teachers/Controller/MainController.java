package com.zx.teachers.Controller;

import com.zx.teachers.ResultVO.LessonVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
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

    @RequestMapping("/userdetail")
    public ModelAndView userDetail(@RequestParam(value = "id", required = true) Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userId", id);
        modelAndView.setViewName("admin/userdetail");
        return modelAndView;
    }

    @RequestMapping("/usercreate")
    public ModelAndView userCreate() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/usercreate");
        return modelAndView;
    }

    @RequestMapping("/lessontable")
    public String lessonTables() {
        return "admin/lessontables";
    }

    @RequestMapping("/lessonedit")
    public ModelAndView lessonEdit(@RequestParam(value = "id", required = true) Integer id){
        log.info("lessonedit执行");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/lessonedit");
        modelAndView.addObject("lessonId", id);
        return modelAndView;
    }

    @RequestMapping("/lessondetail")
    public ModelAndView lessonDetail(@RequestParam(value = "id", required = true) Integer id) {
        log.info("lessondetail执行");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("lessonId", id);
        modelAndView.setViewName("admin/lessondetail");
        return modelAndView;
    }

    @RequestMapping("/lessoncreate")
    public ModelAndView lessonCreate(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/lessoncreate");
        return modelAndView;
    }

    @RequestMapping("/uploadlesson")
    public String uploadLesson() {
        return "admin/uploadlesson";
    }
}
