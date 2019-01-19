package com.zx.teachers.Repository;

import lombok.Data;

@Data
public class SelectLesson {
    private Integer id;
    private Integer userId;
    private Integer lessonId;
    private Integer lessonHour;
}
