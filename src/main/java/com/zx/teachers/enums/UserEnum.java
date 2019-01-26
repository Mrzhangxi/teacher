package com.zx.teachers.enums;

public enum UserEnum {
    NORMAL(1, "正常"),
    DELETED(99, "已注销"),

    TEACHER(100, "教师"),
    LEADER(101, "领导"),

    ;

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    UserEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据FlagCode获取对应的String描述的状态
     * @param value
     * @return
     */
    public static UserEnum getUserFlag(int value) {
        for (UserEnum userEnum : UserEnum.values()) {
            if (value == userEnum.getCode()) {
                return userEnum;
            }
        }
        return null;
    }

    /**
     * 根据TypeCode获取对应的String描述的UserType
     * @param value
     * @return
     */
    public static UserEnum getUserType(int value) {
        for (UserEnum userEnum : UserEnum.values()) {
            if (value == userEnum.getCode()) {
                return userEnum;
            }
        }
        return null;
    }

    /**
     * 根据String类型的描述获取对应的Code
     * @param msg
     * @return
     */
    public static UserEnum getUserCode(String msg) {
        for (UserEnum userEnum : UserEnum.values()) {
            if (msg.equals(userEnum.getMsg())) {
                return userEnum;
            }
        }
        return null;
    }

}
