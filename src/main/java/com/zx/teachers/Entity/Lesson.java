package com.zx.teachers.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "t_lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String lessonName;
    private String lessonDescribe;
    private String lessonImage;
    private Integer lessonClassHour;
    private Date createTime;
    private Date updateTime;
}
