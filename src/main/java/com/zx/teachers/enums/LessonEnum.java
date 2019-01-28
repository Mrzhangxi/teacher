package com.zx.teachers.enums;

public enum LessonEnum {
    WAIT(1, "待开课"),
    PROCESSING(2, "开课中"),
    TESTING(3, "待考试"),
    COMPLETED(4, "已结课"),
    DELETED(99, "已下架"),
    ;

    private Integer code;
    private String msg;

    LessonEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static LessonEnum getLessonFlag(int value) {
        for (LessonEnum lessonEnum : LessonEnum.values()) {
            if (value == lessonEnum.getCode()) {
                return lessonEnum;
            }
        }
        return null;
    }

    public static LessonEnum getLessonCode(String msg) {
        for (LessonEnum lessonEnum : LessonEnum.values()) {
            if (msg == lessonEnum.getMsg()) {
                return lessonEnum;
            }
        }
        return null;
    }

}
