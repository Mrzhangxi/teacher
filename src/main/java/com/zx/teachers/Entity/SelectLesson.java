package com.zx.teachers.Entity;

import lombok.Data;

import javax.persistence.*;

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
}
