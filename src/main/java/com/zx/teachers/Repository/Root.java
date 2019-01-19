package com.zx.teachers.Repository;

import lombok.Data;

import java.util.Date;

@Data
public class Root {
    private Integer id;
    private String adminName;
    private String adminPassword;
    private Date createTime;
    private Date updateTime;

}
