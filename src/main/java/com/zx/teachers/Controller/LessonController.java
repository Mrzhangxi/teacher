package com.zx.teachers.Controller;

import com.zx.teachers.Convertor.LessonConvertor;
import com.zx.teachers.Entity.Lesson;
import com.zx.teachers.ResultVO.LessonVO;
import com.zx.teachers.Service.LessonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/lesson")
@Slf4j
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Lesson create(Lesson lesson) {
        return lessonService.createNewLesson(lesson);
    }

    @RequestMapping("/getbyid")
    @ResponseBody
    public Lesson getByID(@RequestParam(value = "id", required = true) Integer Id){
        return lessonService.getLessonByID(Id);
    }

    @RequestMapping("/getbyname")
    @ResponseBody
    public List<Lesson> getsByname(@RequestParam(value = "lessonname", required = true) String name) {
        return lessonService.getLessonsByName(name);
    }

    @RequestMapping("/getall")
    @ResponseBody
    public List<LessonVO> getAll() {
        log.info("getAllLesson执行");
        List<Lesson> lessons = lessonService.getLessonAll();
        List<LessonVO> lessonVOS = new ArrayList<LessonVO>();
        for (Lesson lesson : lessons) {
            lessonVOS.add(LessonConvertor.lessonToLesonVO(lesson));
        }
        return lessonVOS;
    }

    @RequestMapping("/getbyflag")
    @ResponseBody
    public List<Lesson> getbyFlag(@RequestParam(value = "flag", required = false, defaultValue = "1") Integer flag) {
        return lessonService.getEffLessonAll(flag);
    }

    @RequestMapping("/modify")
    @ResponseBody
    public Lesson modefyLesson(Lesson lesson) {
        return lessonService.modifyLesson(lesson);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Lesson deleteLeson(@RequestParam(value = "id", required = true) Integer Id){
        Lesson lesson = lessonService.getLessonByID(Id);
        return lessonService.deleteLesson(lesson);
    }
}
