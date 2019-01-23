package com.zx.teachers.Entity;

import lombok.Data;

import java.util.Date;

@Data
public class Bbs {
    private Integer id;
    private String bbsTitle;
    private String bbsContent;
    private String bbsAuthor;
    // 状体码，1表示正常，99表示删除
    private Integer bbsFlag;
    private Date createTime;
    private Date updateTime;
}
