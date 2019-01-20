package com.zx.teachers.Repository;

import com.zx.teachers.Entity.SelectLesson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectLessonRepositoryTest {

    @Autowired
    private SelectLessonRepository selectLessonRepository;

    @Test
    public void testBget() {
        List<SelectLesson> selectLessons = selectLessonRepository.findByUserId(2);
        System.out.println(selectLessons);
    }
}