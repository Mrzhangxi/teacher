package com.zx.teachers.Entity;

import lombok.Data;

@Data
public class SelectLesson {
    private Integer id;
    private Integer userId;
    private Integer lessonId;
    private Integer lessonHour;
}
