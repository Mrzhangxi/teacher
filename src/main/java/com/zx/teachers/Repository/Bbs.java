package com.zx.teachers.Repository;

import lombok.Data;

import java.util.Date;

@Data
public class Bbs {
    private Integer id;
    private String bbsTitle;
    private String bbsContent;
    private String bbsAuthor;
    private Date createTime;
    private Date updateTime;
}
