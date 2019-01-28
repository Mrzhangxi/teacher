package com.zx.teachers.ResultVO;

import lombok.Data;

@Data
public class LessonVO {
    private Integer id;
    private String lessonName;
    private String lessonDescribe;
    private String lessonImage;
    private String lessonClassHour;
    private String lessonFlag;
    private String createTime;
    private String updateTime;
}
