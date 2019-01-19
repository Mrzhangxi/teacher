package com.zx.teachers.Exception;

import com.zx.teachers.enums.UtilsEnum;

public class TeacherException extends RuntimeException{

    private Integer code;

    public TeacherException(UtilsEnum utilsEnum) {
        super(utilsEnum.getMessage());
        this.code = utilsEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
