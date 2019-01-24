package com.zx.teachers.Service.Impl;

import com.zx.teachers.Entity.Lesson;
import com.zx.teachers.Repository.LessonRepository;
import com.zx.teachers.Service.LessonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public Lesson createNewLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public Lesson getLessonByID(int id) {
        return lessonRepository.findById(id);
    }

    @Override
    public List<Lesson> getLessonsByName(String name) {
        return lessonRepository.findByLessonNameLike("%" + name + "%");
    }

    @Override
    public List<Lesson> getLessonAll() {
        return lessonRepository.findAll();
    }

    @Override
    public List<Lesson> getEffLessonAll(int flag) {
        return lessonRepository.findAllByLessonFlag(flag);
    }

    @Override
    public Lesson modifyLesson(Lesson lesson) {
        int lessonID = lesson.getId();
        Lesson oldLesson = lessonRepository.findById(lessonID);
        BeanUtils.copyProperties(lesson, oldLesson);
        oldLesson.setId(lessonID);
        lessonRepository.save(oldLesson);
        return lessonRepository.findById(lessonID);
    }

    @Override
    public Lesson deleteLesson(Lesson lesson) {
        int lessonID = lesson.getId();
        Lesson oldLesson = lessonRepository.findById(lessonID);
        oldLesson.setLessonFlag(99);
        lessonRepository.save(oldLesson);
        return lessonRepository.findById(lessonID);
    }
}
