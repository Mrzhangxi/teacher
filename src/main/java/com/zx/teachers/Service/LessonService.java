package com.zx.teachers.Service;

import com.zx.teachers.Entity.Lesson;

import java.util.List;

public interface LessonService {

    /**
     * 添加一门新课程
     * @param lesson
     * @return
     */
    Lesson createNewLesson(Lesson lesson);

    /**
     * 通过id获取课程详情
     * @param id
     * @return
     */
    Lesson getLessonByID(int id);

    /**
     * 根据课程名称获取课程，支持模糊查询
     * @param name
     * @return
     */
    List<Lesson> getLessonsByName(String name);

    /**
     * 获取所有的课程
     * @return
     */
    List<Lesson> getLessonAll();

    /**
     * 获取不同状态的课程
     * @return
     */
    List<Lesson> getEffLessonAll(int flag);

    /**
     * 修改课程信息
     * @param lesson
     * @return
     */
    Lesson modifyLesson(Lesson lesson);

    /**
     * 删除课程，（将课程状态设置为删除，并非真正删除数据）
     * @param lesson
     * @return
     */
    Lesson deleteLesson(Lesson lesson);
}
