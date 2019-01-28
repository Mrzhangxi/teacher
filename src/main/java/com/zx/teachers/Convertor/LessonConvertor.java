package com.zx.teachers.Convertor;

import com.zx.teachers.Entity.Lesson;
import com.zx.teachers.ResultVO.LessonVO;
import com.zx.teachers.Utils.DateUtils;
import com.zx.teachers.enums.LessonEnum;

import java.util.Date;

public class LessonConvertor {

    public static LessonVO lessonToLesonVO(Lesson lesson) {
        LessonVO lessonVO = new LessonVO();
        lessonVO.setId(lesson.getId());
        lessonVO.setLessonName(lesson.getLessonName());
        lessonVO.setLessonDescribe(lesson.getLessonDescribe());
        lessonVO.setLessonImage(lesson.getLessonImage());
        lessonVO.setLessonClassHour(lesson.getLessonClassHour());
        lessonVO.setLessonFlag(LessonEnum.getLessonFlag(lesson.getLessonFlag()).getMsg());
        lessonVO.setUpdateTime(DateUtils.dateToString(lesson.getUpdateTime()));
        lessonVO.setCreateTime(DateUtils.dateToString(lesson.getCreateTime()));
        return lessonVO;
    }

    public static Lesson lessonVOToLesson(LessonVO lessonVO) {
        Lesson lesson = new Lesson();
        lesson.setId(lessonVO.getId());
        lesson.setLessonName(lessonVO.getLessonName());
        lesson.setLessonDescribe(lessonVO.getLessonDescribe());
        if (lessonVO.getLessonImage() != null && !"".equals(lessonVO.getLessonImage())){
            lesson.setLessonImage(lessonVO.getLessonImage());
        } else {
            lesson.setLessonImage("/");
        }
        lesson.setLessonClassHour(lessonVO.getLessonClassHour());
        lesson.setLessonFlag(LessonEnum.getLessonCode(lessonVO.getLessonFlag()).getCode());
        lesson.setUpdateTime(DateUtils.stringToDate(lessonVO.getUpdateTime()));
        lesson.setCreateTime(DateUtils.stringToDate(lessonVO.getCreateTime()));
        return lesson;
    }
}
