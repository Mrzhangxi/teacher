package com.zx.teachers.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity

@Table(name = "t_root")
public class Root {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String adminName;
    private String adminPassword;
    private Date createTime;
    private Date updateTime;


}
