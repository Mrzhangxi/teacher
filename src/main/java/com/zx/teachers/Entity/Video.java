package com.zx.teachers.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String videoName;
    private String videoHref;
    private Integer lesssonId;

}
