package com.zx.teachers.Controller;

import com.zx.teachers.Convertor.LessonConvertor;
import com.zx.teachers.Entity.Lesson;
import com.zx.teachers.ResultVO.LessonVO;
import com.zx.teachers.Service.LessonService;
import com.zx.teachers.Utils.DateUtils;
import com.zx.teachers.Utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/lesson")
@Slf4j
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Lesson create(LessonVO lessonVO,  @RequestParam(value = "lessonimg", required = false) MultipartFile file) {

        String lessonImgPath = null;
        try {
            lessonImgPath = FileUtils.saveUserImg(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        lessonVO.setLessonImage(lessonImgPath );
        lessonVO.setCreateTime(DateUtils.dateToString(new Date()));
        lessonVO.setUpdateTime(DateUtils.dateToString(new Date()));
        Lesson lesson = LessonConvertor.lessonVOToLesson(lessonVO);
        return lessonService.createNewLesson(lesson);
    }

    @RequestMapping("/getbyid")
    @ResponseBody
    public LessonVO getByID(@RequestParam(value = "id", required = true) Integer Id){

        return LessonConvertor.lessonToLesonVO(lessonService.getLessonByID(Id));
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
    public String modefyLesson(LessonVO lessonVO, @RequestParam(value = "lessonimg", required = false) MultipartFile file) {
        String lessonImgPath = null;
        try {
            lessonImgPath = FileUtils.saveUserImg(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        lessonVO.setLessonImage(lessonImgPath );
        lessonVO.setUpdateTime(DateUtils.dateToString(new Date()));
        lessonService.modifyLesson(LessonConvertor.lessonVOToLesson(lessonVO));
        return "admin/success";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Lesson deleteLeson(@RequestParam(value = "id", required = true) Integer Id){
        Lesson lesson = lessonService.getLessonByID(Id);
        return lessonService.deleteLesson(lesson);
    }
}
