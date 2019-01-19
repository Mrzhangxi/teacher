package com.zx.teachers.Utils;

import com.zx.teachers.Exception.TeacherException;
import com.zx.teachers.enums.UtilsEnum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static Date stringToDate(String sdate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(sdate);
        } catch (ParseException e) {
            throw new TeacherException(UtilsEnum.DATE_PRASE_ERROR);
        }
    }
}
