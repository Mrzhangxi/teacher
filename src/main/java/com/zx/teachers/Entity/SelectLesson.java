package com.zx.teachers.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "t_select_lesson")
public class SelectLesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private Integer userId;
    private Integer lessonId;
    private Integer lessonHour;
    private Integer SelectLessonFlag;
    private Date createTime;
    private Date updateTime;
}
