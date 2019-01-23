package com.zx.teachers.Entity;

import lombok.Data;

import java.util.Date;

@Data
public class News {
    private Integer id;
    private String newsTitle;
    private String newsContent;
    private String newsAuthor;
    private Integer newsFlag;
    private Date createTime;
    private Date updateTime;
}
