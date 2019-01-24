package com.zx.teachers.Service.Impl;

import com.zx.teachers.Entity.Lesson;
import com.zx.teachers.Service.LessonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LessonServiceImplTest {

    @Autowired
    private LessonService lessonService;

    @Test
    public void testACreateLesson() {
        Lesson lesson = new Lesson();
        lesson.setLessonName("测试课程2");
        lesson.setLessonDescribe("这是测试课程");
        lesson.setLessonImage("/");
        lesson.setLessonClassHour(50);
        lesson.setLessonFlag(1);

        System.out.println(lessonService.createNewLesson(lesson));
    }

    @Test
    public void testBget() {
        System.out.println(lessonService.getLessonByID(3));
    }

    @Test
    public void testCgetsByname() {
        System.out.println(lessonService.getLessonsByName("测试"));
    }

    @Test
    public void testDgetEffLesson() {
        System.out.println(lessonService.getEffLessonAll(1));
    }

    @Test
    public void testEModifyLesson() {
        Lesson lesson = lessonService.getLessonByID(3);
        lesson.setLessonFlag(99);
        System.out.println(lessonService.modifyLesson(lesson));

        Lesson lesson1 = lessonService.getLessonByID(3);
        lesson.setLessonDescribe("这是修改过的课程");
        lesson.setLessonClassHour(30);
        System.out.println(lessonService.modifyLesson(lesson));
    }

    @Test
    public void testFDeleteLesson() {
        Lesson lesson = new Lesson();
        lesson.setId(1);
        lessonService.deleteLesson(lesson);
    }

}