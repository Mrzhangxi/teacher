package com.zx.teachers.Repository;

import com.zx.teachers.Entity.Lesson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class LessonRepositoryTest {

    @Autowired
    private LessonRepository lessonRepository;

    @Test
    public void testAsave() {
        Lesson lesson = new Lesson();
        lesson.setLessonName("SQL从入门到删库跑路");
        lesson.setLessonImage("/");
        lesson.setLessonClassHour(40);
        lesson.setLessonDescribe("rm -rf");
        Lesson lesson1 = lessonRepository.save(lesson);
        System.out.println(lesson1);
    }

    @Test
    public void testBget() {
        Lesson lesson = lessonRepository.findById(1);
        System.out.println(lesson);
        List<Lesson> lessonList = lessonRepository.findAll();
        System.out.println(lessonList);
    }
}