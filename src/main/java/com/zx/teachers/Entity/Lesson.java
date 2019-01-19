package com.zx.teachers.Entity;

import lombok.Data;

import java.util.Date;

@Data
public class Lesson {
    private Integer id;
    private String lessonName;
    private String lessonDescribe;
    private String image;
    private Integer lessonClassHour;
    private Date createTime;
    private Date updateTime;
}
