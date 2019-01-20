package com.zx.teachers.Repository;

import com.zx.teachers.Entity.SelectLesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SelectLessonRepository extends JpaRepository<SelectLesson, Integer> {

    List<SelectLesson> findByUserId(int id);
}
