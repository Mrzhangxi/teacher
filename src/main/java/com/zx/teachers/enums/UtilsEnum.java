package com.zx.teachers.enums;

public enum  UtilsEnum {
    DATE_PRASE_ERROR(1, "字符串转换时间类型不匹配，需要添加时分秒")
    ;

    private Integer code;
    private String message;

    UtilsEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
