package com.zx.teachers.Repository;

import com.zx.teachers.Entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    Lesson findById(int id);

    List<Lesson> findAll();

    Lesson deleteById(int id);
}
